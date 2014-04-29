(ns libgdx-clj-example.game
    (:import [com.badlogic.gdx Game Screen ScreenAdapter Gdx]
             (com.badlogic.gdx.graphics GL20 OrthographicCamera Color)
             (com.badlogic.gdx.graphics.glutils ShapeRenderer ShapeRenderer$ShapeType)
             (com.badlogic.gdx.utils.viewport ScreenViewport)))

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

(defn- resize [w h viewport]
    (println "Resize! " w " x " h)
    (.update viewport 600 600 true))

(defn create-screen
    "Make a screen"
    []
    (let [cam (OrthographicCamera.)
          shapes (ShapeRenderer.)
          viewport (ScreenViewport. cam)]
        (proxy [Screen] []
            (show []
                (.update viewport 600 600 true))
            (render [delta]
                (render cam shapes delta))
            (dispose [])
            (hide [])
            (pause [])
            (resize [w h]
                (resize w h viewport))
            (resume []))))

;; Game class methods

(defn game-create
    "Create method for a Game"
    [^Game game]
    (println "game created")
    (.setScreen game (create-screen)))

