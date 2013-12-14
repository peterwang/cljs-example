(ns example.hello
  (:require
   [example.crossover.shared :as shared]
   [goog.dom :as dom]
   [goog.events :as events]
   domina))

(defn ua
  []
  (.-userAgent js/navigator))
