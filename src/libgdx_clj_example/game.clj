(ns libgdx-clj-example.game
    (:import [com.badlogic.gdx Game Screen ScreenAdapter]))

(gen-class :name example.core.Game
           :extends Game
           :prefix "game-")

(defn create-screen
    "Make a screen"
    []
    (proxy [Screen] []
        (show [])
        (render [delta])
        (dispose[])
        (hide [])
        (pause [])
        (resize [w h]
            (println "Resize! " w " x " h))
        (resume [])))

;; Game class methods

(defn game-create
    "Create method for a Game"
    [^Game game]
    (println "game created")
    (.setScreen game (create-screen)))

