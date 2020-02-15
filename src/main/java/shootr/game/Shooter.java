package shootr.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;
import shootr.game.scene.scenes.MainMenuScene;
import shootr.game.scene.SceneManager;
import shootr.utils.Fonts;
import shootr.utils.Logger;
import shootr.utils.Timer;

import static org.lwjgl.opengl.GL11.*;

public class Shooter implements Runnable {

    private Timer timer;
    private int width;
    private int height;
    private boolean fullscreen;
    public SceneManager sceneManager;
    private static Shooter shooter;

    public Shooter(int width, int height, boolean fullscreen) {
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        shooter = this;
    }

    public static Shooter getInstance() {
        return shooter;
    }

    @Override
    public void run() {
        init();
        loop();
        shutdown();
    }

    private void init() {
        Logger.info(this, "Running on LWJGL " + Sys.getVersion());

        try {
            Display.setDisplayMode(new DisplayMode(this.width, this.height));
            Display.setFullscreen(this.fullscreen);
            Display.setTitle("shootr");
            Display.create(new PixelFormat(8, 0, 0, 8));
        } catch(LWJGLException e) {
            Logger.fatal(this, "Failed to initialize the display.", e);
            Display.destroy();
            System.exit(-1);
        }

        glViewport(0, 0, this.width, this.height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, this.width, this.height, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        Fonts.init();

        this.sceneManager = new SceneManager(new MainMenuScene());
    }

    private void loop() {
        while(!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            glClearColor(1f, 1f, 1f, 0f);

            input();
            render();
            update();

            Display.update();
            Display.sync(60);
        }
    }

    private void input() {
        this.sceneManager.currentScene.input();

        if(this.sceneManager.overlayScene != null) {
            this.sceneManager.overlayScene.input();
        }
    }

    private void update() {
        this.sceneManager.currentScene.update();

        if(this.sceneManager.overlayScene != null) {
            this.sceneManager.overlayScene.update();
        }
    }

    private void render() {
        this.sceneManager.currentScene.render();

        if(this.sceneManager.overlayScene != null) {
            this.sceneManager.overlayScene.render();
        }
    }

    public void shutdown() {
        Logger.info(this, "Shutting down...");

        Display.destroy();
        System.exit(0);
    }
}
