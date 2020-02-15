package shootr.game.scene.scenes;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import shootr.game.Shooter;
import shootr.game.renderer.Rectangle;
import shootr.game.renderer.Triangle;
import shootr.game.scene.Scene;
import shootr.game.scene.SceneManager;
import shootr.utils.Fonts;

import java.awt.*;

public class GameScene extends Scene {

    private static final int SPEED = 4;

    private Rectangle mapRect;
    private Triangle playerRect;

    public GameScene() {
        this.mapRect = new Rectangle(250, 50, Display.getWidth() - (250 * 2), Display.getHeight() - (50 * 2), Color.BLACK);
        this.playerRect = new Triangle((Display.getWidth() - 50) / 2, (Display.getHeight() - 50) / 2,
                50, 50, Color.WHITE);
    }

    @Override
    public void render() {
        mapRect.draw();
        playerRect.draw();
    }

    @Override
    public void update() {
        Fonts.font24.drawString(5, 5, "X: " + Mouse.getX(), org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 5 + Fonts.font24.getHeight() + 2, "Y: " + Mouse.getY(), org.newdawn.slick.Color.black);
        
        int dX = Mouse.getX() - (playerRect.x + (playerRect.width / 2));
        int dY = Mouse.getY() - playerRect.y;

        Fonts.font24.drawString(5, 65, "X1: " + playerRect.x, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 65 + Fonts.font24.getHeight() + 2, "Y1: " + playerRect.y, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 125, "dx: " + dX, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 125 + Fonts.font24.getHeight() + 2, "dy: " + dY, org.newdawn.slick.Color.black);
    //    System.out.println(dX);
    //    System.out.println(dY);
        double d = Math.toDegrees(Math.atan2(dX, dY));
     //   System.out.println(d);

        Fonts.font24.drawString(5, 175, "rot: " + d, org.newdawn.slick.Color.black);

        playerRect.rotate(d);
    }

    @Override
    public void input() {
        if(Shooter.getInstance().sceneManager.overlayScene instanceof PauseMenuScene) return;
        if(!Keyboard.getEventKeyState()) return;

        if(Keyboard.isKeyDown(Keyboard.KEY_W)) playerRect.y -= SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) playerRect.y += SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) playerRect.x -= SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) playerRect.x += SPEED;

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
