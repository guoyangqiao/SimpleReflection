package closure;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/1/16.
 */
public class Clallbacks {
}

interface Incrementable {
    void increment();

}

class MyIncrement {
    public void increment() {
        System.out.println("orginal increment");
    }

    static void letIncre(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}

class Calle2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            Calle2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {

    private Incrementable callbackReference;

    Caller(Incrementable inc) {
        callbackReference = inc;
    }

    void go() {
        callbackReference.increment();
    }
}