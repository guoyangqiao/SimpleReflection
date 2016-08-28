package control_framework;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/6/16.
 */
public class GreenhouseController extends Controller {
    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long delay) {
            super(delay);
        }

        @Override
        public Object action(Object... params) {
            System.out.println("lightOn");
            return null;
        }

    }

    public class LightOff extends Event {

        public LightOff(long delay) {
            super(delay);
        }

        @Override
        public Object action(Object... params) {
            System.out.println("lightOff");
            return null;
        }

    }

    public class Bell extends Event {

        public Bell(long delay) {
            super(delay);
        }

        @Override
        public Object action(Object... params) {
            add(new Bell(delay));
            System.out.println("bell");
            return null;
        }

    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delay, Event[] list) {
            super(delay);
            this.events = list;
            for (Event e : events) {
                add(e);
                e.start();
            }
        }

        @Override
        public Object action(Object... params) {
            System.out.println("restarting");
            for (Event e : events) {
                e.start();
                add(e);
            }
            start();
            add(this);
            return null;
        }
    }

    public static void main(String[] args) {
        GreenhouseController gc = new GreenhouseController();
//        gc.add(gc.new Bell(1000));
        Event[] events = {
                gc.new LightOn(2000),
                gc.new LightOff(3000)
        };
        gc.add(gc.new Restart(4000, events));
        gc.listen();
    }

}
