package shootr.game.entity.entities;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import shootr.game.entity.Entity;
import shootr.game.renderer.objects.Rectangle;

import java.awt.*;

public class Bullet extends Entity {

    public Vector2f target;
    public Type type;

    public Bullet(double x, double y, Vector2f target, Type type) {
        super(x, y, 16, 16, new Rectangle(x, y, 16, 16, Color.WHITE));
        this.target = target;
        this.type = type;
        System.out.println("i am bullet " + this);
    }

    //TODO: fix shaking at the end
    //TODO: fix bullet not going to mouse pointer
    @Override
    public void update() {
        float targetX = target.x;
        float targetY = target.y;

        float length = (float) Math.sqrt((targetX - x) * (targetX - x) + (targetY - y) * (targetY - y));

        double dx = (target.x - x) / length * 4;
        double dy = (target.y - y) / length * 4;

        move(dx, dy);
    }

    @Override
    public void input() {

    }

    public enum Type {

        NORMAL
    }
}
