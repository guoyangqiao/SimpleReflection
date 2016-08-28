package control_framework;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/5/16.
 */
public abstract class Event<T> {
    protected final long delay;

    private long startTime;

    protected Event(long delay) {
        this.delay = delay;
        start();
    }

    public void start() {
        startTime = System.currentTimeMillis() + delay;
    }

    public boolean ready() {
        return System.currentTimeMillis() > startTime;
    }

    public abstract T action(Object... params);

}
