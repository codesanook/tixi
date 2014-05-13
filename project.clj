(defproject tixi "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [quiescent "0.1.1"]
                 [prismatic/dommy "0.1.1"]
                 [org.clojure/core.async "0.1.301.0-deb34a-alpha"]
                 [prismatic/schema "0.2.2"]
                 [cider/cider-nrepl "0.6.1-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/austin "0.1.4"]
            [cider/cider-nrepl "0.6.1-SNAPSHOT"]]

  :profiles {
    :dev {
       :plugins [[com.cemerick/clojurescript.test "0.3.0"]]}}

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "tixi"
              :source-paths ["src"]
              :compiler {
                :output-to "tixi.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
              {:id "test"
               :source-paths ["src" "test"]
               :notify-command ["phantomjs" :cljs.test/runner "tixi_test.js"]
               :compiler {
                 :output-to "tixi_test.js"
                 :optimizations :whitespace}}]
    :test-commands {"unit"
      ["phantomjs" :runner "textik_test.js"]}})