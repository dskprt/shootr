package shootr.game.entity.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import shootr.game.entity.Entity;
import shootr.game.renderer.objects.Rectangle;
import shootr.game.renderer.objects.Triangle;
import shootr.game.world.World;

import java.awt.*;

public class Player extends Entity {

    private static final int SPEED = 4;
    private static final int ROTATE_SPEED = 5;
    private static int SHOOT_DELAY = 0;

    public Rectangle mapRect;
    public World world;

    public Player(World world, Rectangle mapRect) {
        super((Display.getWidth() - 50) / 2, (Display.getHeight() - 40) / 2, 50, 40,
                new Triangle((Display.getWidth() - 50) / 2, (Display.getHeight() - 40) / 2,
                50, 40, Color.WHITE));

        this.mapRect = mapRect;
        this.world = world;
    }

    @Override
    public void update() {
        // TODO: fix rotation to mouse pointer
        /*
        Fonts.font24.drawString(5, 5, "X: " + Mouse.getX(), org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 5 + Fonts.font24.getHeight() + 2, "Y: " + Mouse.getY(), org.newdawn.slick.Color.black);

        int dX = Mouse.getX() - box.x;
        int dY = Mouse.getY() - box.y;

        Fonts.font24.drawString(5, 65, "X1: " + playerRect.x, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 65 + Fonts.font24.getHeight() + 2, "Y1: " + playerRect.y, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 125, "dx: " + dX, org.newdawn.slick.Color.black);
        Fonts.font24.drawString(5, 125 + Fonts.font24.getHeight() + 2, "dy: " + dY, org.newdawn.slick.Color.black);

        double d = Math.toDegrees(Math.atan2(dX, dY));

        Fonts.font24.drawString(5, 175, "rot: " + d, org.newdawn.slick.Color.black);

        box.rotate(d);
         */
    }

    @Override
    public void input() {
        //if(this.isCollidingWith(this.mapRect.x, this.mapRect.y, this.mapRect.width, this.mapRect.height)) {
        //    return;
        //}

        if(Keyboard.isKeyDown(Keyboard.KEY_W)) move(0, -SPEED);
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) move(0, SPEED);
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) move(-SPEED, 0);
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) move(SPEED, 0);

        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) this.rendererObject.rotation -= ROTATE_SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) this.rendererObject.rotation += ROTATE_SPEED;

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && SHOOT_DELAY <= 0) {
            this.world.addEntity(new Bullet(this.x, this.y, new Vector2f(Mouse.getX(), Mouse.getY()), Bullet.Type.NORMAL));
            SHOOT_DELAY = 1 * 60;
        }

        if(SHOOT_DELAY > 0) {
            SHOOT_DELAY--;
        }
    }
}
