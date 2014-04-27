(ns libgdx-clj-example.game
    (:import [com.badlogic.gdx Game Screen ScreenAdapter Gdx]
             (com.badlogic.gdx.graphics GL20)))

(gen-class :name example.core.Game
           :extends com.badlogic.gdx.Game
           :prefix "game-")

;; cheap and easy way to change methods on reload. Delegate to another method!

(defn- render [delta]
    (doto Gdx/gl
        (.glClearColor 0 0 0 0)
        (.glClear GL20/GL_COLOR_BUFFER_BIT)))

(defn- resize [w h]
    (println "Resize! " w " x " h))

(defn create-screen
    "Make a screen"
    []
    (proxy [Screen] []
        (show [])
        (render [delta]
            (render delta))
        (dispose [])
        (hide [])
        (pause [])
        (resize [w h]
            (resize w h))
        (resume [])))

;; Game class methods

(defn game-create
    "Create method for a Game"
    [^Game game]
    (println "game created")
    (.setScreen game (create-screen)))

