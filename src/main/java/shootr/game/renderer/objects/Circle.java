package shootr.game.renderer.objects;

import shootr.game.renderer.RendererObject;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Circle extends RendererObject {

    public Circle(double x, double y, int radius, Color color) {
        super(x, y, radius * 2, radius * 2, color, 0, false);
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

        if(this.outline) {
            glBegin(GL_LINE_LOOP);

            for(int i = 0; i <= 360; i++) {
                double angle = 2.0 * Math.PI * i / 360.0;

                double x = this.width * Math.cos(angle);
                double y = this.height * Math.sin(angle);

                glVertex2d(x + this.x, y + this.y);
            }

            glEnd();
        } else {
            glBegin(GL_TRIANGLE_FAN);
            glVertex2d(this.x + (this.width / 2), this.y + (this.height / 2));

            for(int i = 0; i <= 360; i++) {
                glVertex2d((this.x + (this.width * Math.cos(i * (Math.PI * 2) / 360))),
                        (this.y + (this.height * Math.sin(i * (Math.PI * 2) / 360))));
            }

            glEnd();
        }

        glEnable(GL_BLEND);
        glPopMatrix();
    }
}
