package mysterious_garden;

import java.util.concurrent.atomic.AtomicInteger;

public class Gate {

    private String name;
    private AtomicInteger in = new AtomicInteger();

    public Gate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getIn() {
        return in;
    }

    public void in() {
        this.in.addAndGet(1);
    }

    @Override
    public String toString() {
        return "Gate{" +
                "name='" + name + '\'' +
                ", in=" + in +
                '}';
    }
}
