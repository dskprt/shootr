package shootr.main;

import shootr.game.Shooter;

public class Launcher {

    public static void main(String[] args) {
        new Shooter(1366, 768, false).run();
    }
}
