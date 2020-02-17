package shootr.game.renderer.objects;

import shootr.game.renderer.RendererObject;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Triangle extends RendererObject {

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color, 0, false);
    }

    @Override
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

        glBegin(GL_TRIANGLES);
        glVertex2f(this.x + (this.width / 2), this.y);
        glVertex2f(this.x, this.y + this.height);
        glVertex2f(this.x + this.width, this.y + this.height);
        glEnd();

        glEnable(GL_BLEND);
        glPopMatrix();
    }
}
