(defproject pe2c-cljs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0-alpha4"]
                 [org.clojure/clojurescript "1.10.191"]
                 [reagent "0.8.0-alpha2"]
                 [garden "1.3.4"]
                 [tongue "0.2.4"]
                 [re-frame "0.10.5"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-garden "0.3.0"]]
  :min-lein-version "2.5.3"
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :figwheel {:css-dirs ["resources/public/css"]
             :repl false}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.9"]]
                   :plugins [[lein-figwheel "0.5.16-SNAPSHOT"]
                             [lein-pdo "LATEST"]]}}
  :garden {:builds [{:id "stylesheet"
                     :source-paths ["src"] ;; ulgy thing because it doesn't reload otherwiser
                     :stylesheet pe2c-cljs.styles/sheet
                     :compiler {:output-to "resources/public/css/stylesheet.css"
                                :pretty-print? true}}]}
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/pe2c_cljs"]
                :figwheel {:on-jsload "pe2c-cljs.core/mount-root"}
                :compiler {:main pe2c-cljs.core
                           :output-to "resources/public/js/compiled/app.js"
                           :output-dir "resources/public/js/compiled/out"
                           :asset-path "js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]
                           :external-config {:devtools/config {:features-to-install :all}}}}
               {:id "min"
                :source-paths ["src/pe2c_cljs"]
                :compiler {:main pe2c-cljs.core
                           :output-to "resources/public/js/compiled/app.js"
                           :optimizations :advanced
                           :closure-defines {goog.DEBUG false}
                           :pretty-print false}}]})
