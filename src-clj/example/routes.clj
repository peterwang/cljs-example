(ns example.routes
  (:use compojure.core
        example.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            ring.adapter.jetty
            [cemerick.austin.repls :as repls]))

(defroutes main-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))

(defn run
  []
  (defonce ^:private server
    (ring.adapter.jetty/run-jetty #'app {:port 8080 :join? false}))
  server)

(defn js
  []
  (def ^:private repl-env
    (reset! cemerick.austin.repls/browser-repl-env
            (cemerick.austin/repl-env)))
  (cemerick.austin.repls/cljs-repl repl-env)
  (println "Now go refresh the page"))
