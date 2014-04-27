(ns libgdx-clj-example.game
    (:import [com.badlogic.gdx Game]))

(gen-class :name example.core.Game
           :extends Game
           :prefix "game-")

(defn game-create
    "Create method for a Game"
    [^Game game]
    (println "game created"))

