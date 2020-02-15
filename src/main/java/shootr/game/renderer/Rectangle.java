package shootr.game.renderer;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle {

    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;
    public double rotation;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.rotation = 0;
    }

    public void draw() {
        glPushMatrix();
        glDisable(GL_BLEND);

        glTranslatef(+(this.x + this.width / 2), +(this.y + this.height / 2), 0);
        glRotated(this.rotation, 0, 0, 1);
        glTranslatef(-(this.x + this.width / 2), -(this.y + this.height / 2), 0);

        glColor4f(this.color.getRed() / 255f,
                this.color.getGreen() / 255f,
                this.color.getBlue() / 255f,
                this.color.getAlpha() / 255f);

        glBegin(GL_QUADS);
        glVertex2f(this.x, this.y);
        glVertex2f(this.x, this.y + this.height);
        glVertex2f(this.x + this.width, this.y + this.height);
        glVertex2f(this.x + this.width, this.y);
        glEnd();

        glEnable(GL_BLEND);
        glPopMatrix();
    }

    public Rectangle position(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }

    public Rectangle size(int width, int height) {
        this.width = width;
        this.height = height;

        return this;
    }

    public Rectangle rotate(double rotation) {
        this.rotation = rotation;
        return this;
    }

    public Rectangle color(Color color) {
        this.color = color;
        return this;
    }
}
