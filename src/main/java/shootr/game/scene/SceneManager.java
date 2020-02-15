package shootr.game.scene;

public class SceneManager {

    public Scene currentScene;
    public Scene overlayScene;

    public SceneManager(Scene defaultScene) {
        this.currentScene = defaultScene;
    }
}
