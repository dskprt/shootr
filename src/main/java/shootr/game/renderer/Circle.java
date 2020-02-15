package shootr.game.renderer;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Circle implements RenderObject {

    public int x;
    public int y;
    public int radius;
    public Color color;
    public double rotation;

    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.rotation = 0;
    }

    @Override
    public void draw() {
        glPushMatrix();
        glDisable(GL_BLEND);

        glTranslatef(+(this.x + this.radius / 2), +(this.y + this.radius / 2), 0);
        glRotated(this.rotation, 0, 0, 1);
        glTranslatef(-(this.x + this.radius / 2), -(this.y + this.radius / 2), 0);

        glColor4f(this.color.getRed() / 255f,
                this.color.getGreen() / 255f,
                this.color.getBlue() / 255f,
                this.color.getAlpha() / 255f);

        glBegin(GL_LINE_LOOP);

        for(int i = 0; i < 360; i++) {
            double angle = 2.0 * Math.PI * i / 360.0;

            double x = this.radius * Math.cos(angle);
            double y = this.radius * Math.sin(angle);

            glVertex2f((float) x + (float) this.x, (float) y + (float) this.y);
        }

        glEnd();

        glEnable(GL_BLEND);
        glPopMatrix();
    }

    public Circle position(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }

    public Circle size(int radius) {
        this.radius = radius;

        return this;
    }

    public Circle rotate(double rotation) {
        this.rotation = rotation;
        return this;
    }

    public Circle color(Color color) {
        this.color = color;
        return this;
    }
}
