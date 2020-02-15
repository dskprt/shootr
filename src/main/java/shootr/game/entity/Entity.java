package shootr.game.entity;

import shootr.game.renderer.RenderObject;

public abstract class Entity {

    public int x;
    public int y;
    public int width;
    public int height;
    public RenderObject renderObject;

    public Entity(int x, int y, int width, int height, RenderObject renderObject) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.renderObject = renderObject;
    }

    public abstract void update();
    public abstract void input();

    public void render() {
        this.renderObject.draw();
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
}
