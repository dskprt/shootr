package shootr.game.entity;

import shootr.game.renderer.RendererObject;

public abstract class Entity {

    public double x;
    public double y;
    public int width;
    public int height;
    public RendererObject rendererObject;

    public Entity(double x, double y, int width, int height, RendererObject rendererObject) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rendererObject = rendererObject;
    }

    public abstract void update();
    public abstract void input();

    public void render() {
        this.rendererObject.draw();
    }

    // TODO: fix
    public boolean isCollidingWith(Entity other) {
        if(other.width > 0 && other.height > 0 && this.width > 0 && this.height > 0) {
            return ((other.width + other.x) < other.x || (other.width + other.x) > this.x)
                    && ((this.height + other.y) < other.y || (this.height + other.y) > this.y)
                    && ((this.width + this.x) < this.x || (this.width + this.x) > other.x)
                    && ((this.height + this.y) < this.y || (this.height + this.y) > other.y);
        } else {
            return false;
        }
    }

    //TODO: fix
    public boolean isCollidingWith(int x, int y, int width, int height) {
        if(width > 0 && height > 0 && this.width > 0 && this.height > 0) {
            return ((width + x) < x || (width + x) > this.x)
                    && ((this.height + y) < y || (this.height + y) > this.y)
                    && ((this.width + this.x) < this.x || (this.width + this.x) > x)
                    && ((this.height + this.y) < this.y || (this.height + this.y) > y);
        } else {
            return false;
        }
    }

    public void move(double addX, double addY) {
        this.x += addX;
        this.y += addY;
        this.rendererObject.x += addX;
        this.rendererObject.y += addY;
    }
}
