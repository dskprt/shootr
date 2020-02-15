package shootr.game.scene.scenes;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import shootr.game.Shooter;
import shootr.game.scene.Scene;
import shootr.game.scene.SceneManager;
import shootr.utils.Fonts;

public class MainMenuScene extends Scene {

    private String[] options = {
            "shootr",
            "[play]",
            "[options]",
            "[exit]"
    };

    private int selection = 0;

    @Override
    public void render() {
        int centerY = (Display.getHeight() - Fonts.font48.getHeight()) / 2;

        Fonts.font48.drawString((Display.getWidth() - Fonts.font48.getWidth(options[0])) / 2,
                centerY - (Fonts.font48.getHeight() - 5) * 2, options[0], Color.black);
        Fonts.font48.drawString((Display.getWidth() - Fonts.font48.getWidth(options[1])) / 2,
                centerY, options[1], (selection == 0) ? Color.gray.darker(0.25f) : Color.black);
        Fonts.font48.drawString((Display.getWidth() - Fonts.font48.getWidth(options[2])) / 2,
                centerY + (Fonts.font48.getHeight() - 12), options[2], (selection == 1) ? Color.gray.darker(0.25f) : Color.black);
        Fonts.font48.drawString((Display.getWidth() - Fonts.font48.getWidth(options[3])) / 2,
                centerY + (Fonts.font48.getHeight() - 12) * 2, options[3], (selection == 2) ? Color.gray.darker(0.25f) : Color.black);
    }

    @Override
    public void input() {
        while(Keyboard.next()) {
            if(Keyboard.isRepeatEvent()) return;

            if(Keyboard.getEventKeyState()) {
                switch(Keyboard.getEventKey()) {
                    case Keyboard.KEY_UP:
                        if(selection == 0) {
                            selection = 2;
                        } else {
                            selection--;
                        }

                        break;
                    case Keyboard.KEY_DOWN:
                        if(selection == 2) {
                            selection = 0;
                        } else {
                            selection++;
                        }

                        break;
                    case Keyboard.KEY_RETURN:
                        switch(selection) {
                            case 0:
                                Shooter.getInstance().sceneManager.currentScene = new GameScene();
                                break;
                            case 1:
                                break;
                            case 2:
                                Shooter.getInstance().shutdown();
                                break;
                        }

                        break;
                }
            }
        }
    }
}
