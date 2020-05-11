(defproject {{ raw-name }} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.9.3"

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.758"]{{#react?}}
                 [cljsjs/react "16.13.1-0"]
                 [cljsjs/react-dom "16.13.1-0"]
                 [cljsjs/create-react-class "15.6.3-1"]
                 [sablono "0.8.6"]{{/react?}}{{#om?}}
                 [cljsjs/react "16.13.1-0"]
                 [cljsjs/react-dom "16.13.1-0"]
                 [cljsjs/create-react-class "15.6.3-1"]
                 [sablono "0.8.6"]
                 [org.omcljs/om "1.0.0-beta4"]{{/om?}}{{#reagent?}}
                 [reagent "1.0.0-alpha1"]{{/reagent?}}{{#rum?}}
                 [rum "0.11.5"]{{/rum?}}]

  :source-paths ["src"]

  :aliases {"fig"       [{{^windows?}}"trampoline" {{/windows?}}"run" "-m" "figwheel.main"]
            "fig:build" [{{^windows?}}"trampoline" {{/windows?}}"run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:test"  ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" "{{test-runner-ns}}"]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.4"]{{^windows?}}
                                  [com.bhauman/rebel-readline-cljs "0.1.4"]{{/windows?}}]
                   {{#deps?}}:resource-paths ["target"]
                   ;; need to add the compiled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["target"]{{/deps?}}}})

