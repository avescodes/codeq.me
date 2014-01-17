(defproject me.codeq/website "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://github.com/rkneufeld/codeq.me"
  :license {:name "CC BY-NC-SA 4.0"
            :url "http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [io.pedestal/pedestal.service "0.2.2"]
                 [io.pedestal/pedestal.service-tools "0.2.2"]
                 [com.datomic/datomic-pro "0.9.4384"]
                 [io.pedestal/pedestal.jetty "0.2.2"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :aliases {"run-dev" ["trampoline" "run" "-m" "me.codeq.website.server/run-dev"]}
  :repl-options  {:init-ns user
                  :init (try
                          (use 'io.pedestal.service-tools.dev)
                          (require 'me.codeq.website.service)
                          ;; Nasty trick to get around being unable to reference non-clojure.core symbols in :init
                          (eval '(init me.codeq.website.service/service #'me.codeq.website.service/routes))
                          (catch Throwable t
                            (println "ERROR: There was a problem loading io.pedestal.service-tools.dev")
                            (clojure.stacktrace/print-stack-trace t)
                            (println)))
                  :welcome (println "Welcome to pedestal-service! Run (tools-help) to see a list of useful functions.")}
  :main ^{:skip-aot true} me.codeq.website.server)
