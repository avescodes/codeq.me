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

(defn- flatten-commit-src-pairs
  "Flatten each value commit-src pair down to a sequence of commits.

  Example:
  {:a [[:a 1] [:a 2]]} -> {:a [1 2]}"
  [m]
  (into {}
        (map (fn [[src pairs]] [src (map second pairs)])
             m)))

(defn- sha->commit
  "Transform a commit SHA (or sequence of SHAs) into a map of SHA to commit
  entities."
  [db & shas]
  (->> (d/q '[:find ?sha ?commit
              :in $ [?sha ...]
              :where [?commit :git/sha ?sha]]
            db
            shas)
       (map (fn [[sha commit]] [sha (d/entity db commit)]))
       (into {})))

(defn- hydrate-shas
  [db m]
  (into {}
        (map (fn [[src shas]] [src (map (apply sha->commit db shas) shas)])
             m)))

(defn- pick-earliest-commit
  [m]
  (into {}
        (map (fn [[src shas]] [src (first (sort-by :commit/authoredAt shas))])
             m)))

(defn versions [db def]
  (->> (d/q '[:find ?src ?sha
              :in $ % ?name
              :where
              [?n :code/name ?name]
              [?cq :clj/def ?n]
              [?cq :codeq/code ?cs]
              [?cs :code/text ?src]
              (codeq-commits ?codeq ?c)
              (?c :git/sha ?sha)]
            db rules def)
       (group-by first)
       flatten-commit-src-pairs
       (hydrate-shas db)
       pick-earliest-commit)) ;; Presently seems to always be the first commit.




