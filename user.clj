(ns user)
(require '[datomic.api :as d :refer [q db]])

(def uri "datomic:dev://localhost:4334/git")
(def conn nil)

(defn connect []
  (alter-var-root (var conn) (fn [_] (d/connect uri))))

(defn list-defns [conn]
  (let [results (q '[:find ?name
                     :where
                     [?code :code/name ?name]
                     [?codeq :clj/def ?code]
                     [?codeq :clj/defop "defn"]]
                   (db conn))]
    (into #{} (map first results))))

(def rules
  '[[(node-files ?n ?f) [?n :node/object ?f] [?f :git/type :blob]]
    [(node-files ?n ?f) [?n :node/object ?t] [?t :git/type :tree]
     [?t :tree/nodes ?n2] (node-files ?n2 ?f)]
    [(object-nodes ?o ?n) [?n :node/object ?o]]
    [(object-nodes ?o ?n) [?n2 :node/object ?o] [?t :tree/nodes ?n2] (object-nodes ?t ?n)]
    [(commit-files ?c ?f) [?c :commit/tree ?root] (node-files ?root ?f)]
    [(commit-codeqs ?c ?cq) (commit-files ?c ?f) [?cq :codeq/file ?f]]
    [(file-commits ?f ?c) (object-nodes ?f ?n) [?c :commit/tree ?n]]
    [(codeq-commits ?cq ?c) [?cq :codeq/file ?f] (file-commits ?f ?c)]])

(defn- flatten-src-commit-pairs
  "Flatten each value commit-src pair down to a sequence of commits.

  Example:
  {:a [[:a 1] [:a 2]]} -> {:a [1 2]}"
  [m]
  (map (fn [[src pairs]] [src (map second pairs)])
       m))

(defn- entitize
  [db m]
  (map (fn [[src commits]] [src (map (partial d/entity db) commits)])
       m))

(defn- select-earliest-sha
  [m]
  (map (fn [[src commits]]
         [src (first (sort-by :commit/authoredAt commits))])
       m))

(defn versions [db def]
  (->> (d/q '[:find ?src ?c
              :in $ % ?name
              :where
              [?n :code/name ?name]
              [?cq :clj/def ?n]
              [?cq :codeq/code ?cs]
              [?cs :code/text ?src]
              (codeq-commits ?cq ?c)]
            db rules def)
       (group-by first)
       flatten-src-commit-pairs
       (entitize db)
       select-earliest-sha
       (into {})))






