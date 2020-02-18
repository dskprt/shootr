package shootr.game.renderer.objects;

import shootr.game.renderer.RendererObject;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle extends RendererObject {

    public Rectangle(double x, double y, int width, int height, Color color) {
        super(x, y, width, height, color, 0, false);
    }

    @Override
    public void draw() {
        glPushMatrix();
        glDisable(GL_BLEND);

        glTranslated(+(this.x + this.width / 2), +(this.y + this.height / 2), 0);
        glRotated(this.rotation, 0, 0, 1);
        glTranslated(-(this.x + this.width / 2), -(this.y + this.height / 2), 0);

        glColor4f(this.color.getRed() / 255f,
                this.color.getGreen() / 255f,
                this.color.getBlue() / 255f,
                this.color.getAlpha() / 255f);

        glBegin(GL_QUADS);
        glVertex2d(this.x, this.y);
        glVertex2d(this.x, this.y + this.height);
        glVertex2d(this.x + this.width, this.y + this.height);
        glVertex2d(this.x + this.width, this.y);
        glEnd();

        glEnable(GL_BLEND);
        glPopMatrix();
    }
}
