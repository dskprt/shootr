package shootr.game.scene.scenes;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import shootr.game.Shooter;
import shootr.game.entity.Entity;
import shootr.game.entity.entities.Enemy;
import shootr.game.entity.entities.Player;
import shootr.game.renderer.objects.Rectangle;
import shootr.game.scene.Scene;
import shootr.game.world.World;

import java.awt.*;
import java.util.Map;
import java.util.Random;

public class GameScene extends Scene {

    private Rectangle mapRect;
    private Player player;
    private World world;

    private Random r = new Random();

    public GameScene() {
        this.world = new World();

        this.mapRect = new Rectangle(250, 50, Display.getWidth() - (250 * 2), Display.getHeight() - (50 * 2), Color.BLACK);
        this.player = new Player(this.mapRect);

        this.world.addEntity(0, this.player);

        // testing
        for(int i = 0; i < 100; i++) {
            this.world.addEntity(i + 1, new Enemy(r.nextInt(Display.getWidth()), r.nextInt(Display.getHeight()), 100));
        }
    }

    @Override
    public void render() {
        mapRect.draw();

        for(Map<Integer, Entity> map : this.world.entities) {
            for(Entity e : map.values()) {
                e.render();
            }
        }
    }

    @Override
    public void update() {
        for(Map<Integer, Entity> map : this.world.entities) {
            for(Entity e : map.values()) {
                e.update();
            }
        }
    }

    @Override
    public void input() {
        if(Shooter.getInstance().sceneManager.overlayScene instanceof PauseMenuScene) return;
        if(!Keyboard.getEventKeyState()) return;

        for(Map<Integer, Entity> map : this.world.entities) {
            for(Entity e : map.values()) {
                e.input();
            }
        }

        if(!Keyboard.isRepeatEvent() && Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            Shooter.getInstance().sceneManager.overlayScene = new PauseMenuScene();
            return;
        }
    }

    //TODO: fix
    public static class PauseMenuScene extends Scene {

        private Rectangle bgRect;

        public PauseMenuScene() {
            this.bgRect = new Rectangle(0, 0, Display.getWidth(), Display.getHeight(), new Color(
                    0,
                    0,
                    0,
                    180
            ));
        }

        @Override
        public void render() {
            bgRect.draw();
        }

        @Override
        public void input() {
            if(Keyboard.getEventKeyState()) {
                if(!Keyboard.isRepeatEvent() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
                    Shooter.getInstance().sceneManager.overlayScene = null;
                }
            }
        }
    }
}
