(defproject libgdx-clj-example "0.1.0-SNAPSHOT"
    :description "Example clojure application with native libgdx integration."
    :url "http://github.com/markmandel/libgdx-clj-example"
    :license {:name "Eclipse Public License"
              :url  "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[com.badlogicgames.gdx/gdx "1.0.0"]
                   [com.badlogicgames.gdx/gdx-backend-lwjgl "1.0.0"]
                   [com.badlogicgames.gdx/gdx-box2d "1.0.0"]
                   [com.badlogicgames.gdx/gdx-box2d-platform "1.0.0"
                    :classifier "natives-desktop"]
                   [com.badlogicgames.gdx/gdx-platform "1.0.0"
                    :classifier "natives-desktop"]
                   [org.clojure/clojure "1.6.0"]]

    :aot :all
    :main libgdx-clj-example.core
    :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                    [org.clojure/tools.trace "0.7.8"]]}})