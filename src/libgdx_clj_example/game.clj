(ns libgdx-clj-example.game
    (:import [com.badlogic.gdx Game Screen ScreenAdapter Gdx]
             (com.badlogic.gdx.graphics GL20 OrthographicCamera Color)
             (com.badlogic.gdx.graphics.glutils ShapeRenderer ShapeRenderer$ShapeType)))

(gen-class :name example.core.Game
           :extends com.badlogic.gdx.Game
           :prefix "game-")

;; cheap and easy way to change methods on reload. Delegate to another method!

(defn- render [cam shapes delta]
    (doto Gdx/gl
        (.glClearColor 0 0 0 0)
        (.glClear GL20/GL_COLOR_BUFFER_BIT))
    (doto cam
        (.update))
    (doto shapes
        (.setProjectionMatrix (.combined cam))
        (.begin ShapeRenderer$ShapeType/Filled)
        (.setColor Color/WHITE)
        (.rect 50 50 50 50)
        (.end)))

(defn- resize [w h]
    (println "Resize! " w " x " h))

(defn create-screen
    "Make a screen"
    []
    (let [cam (OrthographicCamera. 600 600)
          shapes (ShapeRenderer.)]
        (proxy [Screen] []
            (show []
                (.set (.position cam) 300 300 0))
            (render [delta]
                (render cam shapes delta))
            (dispose [])
            (hide [])
            (pause [])
            (resize [w h]
                (resize w h))
            (resume []))))

;; Game class methods

(defn game-create
    "Create method for a Game"
    [^Game game]
    (println "game created")
    (.setScreen game (create-screen)))

