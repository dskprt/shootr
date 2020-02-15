package shootr.utils;

public class Timer {

    private double last;
    private float count;
    private int frames;
    private int fps;

    public Timer() {
        this.last = getTime();
    }

    public void update() {
        if(this.count > 1f) {
            this.fps = frames;
            this.frames = 0;

            this.count -= 1f;
        }
    }

    public float getDelta() {
        double time = getTime();
        float delta = (float) (time - this.last);

        this.last = time;
        this.count += delta;

        return delta;
    }

    public double getTime() {
        return System.nanoTime() / 1000000000D;
    }

    public int getFPS() {
        return (this.fps > 0) ? this.fps : this.frames;
    }
}
