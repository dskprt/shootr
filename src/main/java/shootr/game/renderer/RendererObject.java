package shootr.game.renderer;

import java.awt.*;

public abstract class RendererObject {

    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;
    public double rotation;
    public boolean outline;

    public RendererObject(int x, int y, int width, int height, Color color, double rotation, boolean outline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.rotation = rotation;
        this.outline = outline;
    }

    public abstract void draw();

    public RendererObject position(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }

    public RendererObject size(int width, int height) {
        this.width = width;
        this.height = height;

        return this;
    }

    public RendererObject color(Color color) {
        this.color = color;

        return this;
    }

    public RendererObject rotate(double degrees) {
        this.rotation = degrees;

        return this;
    }

    public RendererObject outline(boolean outline) {
        this.outline = outline;

        return this;
    }
}
