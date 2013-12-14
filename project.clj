(defproject cljs-example "0.0.1"
  :description "An example of clojurescript"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2120"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [domina "1.0.2"]]
  :plugins [[lein-cljsbuild "1.0.1"]
            [com.cemerick/austin "0.1.3"]]
  :crossovers [example.crossover]
  :crossover-jar true
  :cljsbuild {:builds {:dev {:source-paths ["src-cljs"]
                             :jar true
                             :compiler {:output-to "resources/public/js/main-debug.js"
                                        :optimizations :whitespace
                                        :pretty-print true}}}})
