(ns libgdx-clj-example.core
    (:gen-class)
    (:require [libgdx-clj-example.game])
    (:import (com.badlogic.gdx.backends.lwjgl LwjglApplication)))

(defn -main
    "Run the game"
    [& args]
    (println "Hello, World!")
    (LwjglApplication. (example.core.Game.) "Example Clojure" 600 600))
