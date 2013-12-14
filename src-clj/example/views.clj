(ns example.views
  (:require
   [example.crossover.shared :as shared]
   [cemerick.austin.repls :refer (browser-connected-repl-js)]
   [hiccup
    [page :refer [html5]]
    [element :refer [javascript-tag]]
    [page :refer [include-js]]]))

(defn- run-clojurescript [path init]
  (list
   (include-js path)
   (javascript-tag init)))

(defn index-page []
  (html5
   [:head
    [:title (shared/make-example-text)] ]
   [:body
    [:h1 (shared/make-example-text)]
    [:div {:id "items"}]
    (run-clojurescript
     "/js/main-debug.js"
     "")
    [:script (cemerick.austin.repls/browser-connected-repl-js)]]))
