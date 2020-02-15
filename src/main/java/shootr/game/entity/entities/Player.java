package shootr.game.entity.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import shootr.game.entity.Entity;
import shootr.game.renderer.Rectangle;
import shootr.game.renderer.Triangle;

import java.awt.*;

public class Player extends Entity {

    private static final int SPEED = 4;
    private static final int ROTATE_SPEED = 5;

    public Triangle box;
    public Rectangle mapRect;

    public Player(Rectangle mapRect) {
        super((Display.getWidth() - 50) / 2, (Display.getHeight() - 40) / 2, 50, 40,
                new Triangle((Display.getWidth() - 50) / 2, (Display.getHeight() - 40) / 2,
                50, 40, Color.WHITE));

        this.box = (Triangle) this.renderObject;
        this.mapRect = mapRect;
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

        if(Keyboard.isKeyDown(Keyboard.KEY_W)) box.y -= SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) box.y += SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) box.x -= SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) box.x += SPEED;

        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) box.rotation -= ROTATE_SPEED;
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) box.rotation += ROTATE_SPEED;
    }
}
