(ns http-server.main
  (:gen-class)
  (:require [clojure.tools.cli :as cli]
            [http-server.server :as server]))

(defn -main [& args]
  (let [[options args banner]
        (cli/cli args
                 ["-p" "--port" "Listen on this port" :default "5000"]
                 ["-d" "--directory" :default "public/"])
        port (Integer. (get options :port))
        directory (get options :directory)]
    (server/server port directory)))