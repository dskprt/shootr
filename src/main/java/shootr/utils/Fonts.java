package shootr.utils;

import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.io.IOException;

public class Fonts {

    private static final String FONT_PATH = "/mago.ttf";

    public static TrueTypeFont font24;
    public static TrueTypeFont font30;
    public static TrueTypeFont font40;
    public static TrueTypeFont font48;

    public static void init() {
        font24 = loadFont(24);
        font30 = loadFont(30);
        font40 = loadFont(40);
        font48 = loadFont(48);
    }

    public static TrueTypeFont loadFont(float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Fonts.class.getResourceAsStream(FONT_PATH));
            return new TrueTypeFont(font.deriveFont(size), false);
        } catch(FontFormatException | IOException e) {
            Logger.fatal(Fonts.class, "Failed to create the font.", e);
        }

        return null;
    }
}
