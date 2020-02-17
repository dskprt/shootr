package shootr.game.entity.entities;

import shootr.game.entity.Entity;
import shootr.game.renderer.objects.Circle;

import java.awt.*;

public class Enemy extends Entity {

    public int health;

    public Enemy(int x, int y, int health) {
        super(x, y, 50, 50, new Circle(x, y, 10, Color.orange));
        this.health = health;
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {

    }
}
