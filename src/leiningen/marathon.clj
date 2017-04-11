(ns leiningen.marathon
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [cheshire.core :refer :all]))

(defn- map-to-json-uppercase [m]
  (generate-string m {:key-fn (fn [k]
                                (-> k
                                  name
                                  str/upper-case
                                  (str/replace "-" "_")))}))

(defn- get-path [project phase]
  (case phase
    "dev" (let [phase (keyword "project" phase)]
            (-> project
              :profiles
              phase
              :resource-paths
              first))
    "prod" (-> project
             :profiles
             :uberjar
             :resource-paths
             first)))

(defn- load-config [project phase]
  (load-file (str (:root project) "/" (get-path project phase) "/config.edn")))

(defn marathon
  "Make marathon config"
  [project & args]
  (println "creating....")
  (let [phase (or (first args) "dev")
        filename (str "marathon_config" "_" phase)
        config (load-config project phase)]
    (spit (io/file (:root project) filename)
      (map-to-json-uppercase config))
    (println "done" (str (:root project) "/" filename))))
