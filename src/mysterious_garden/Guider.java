package mysterious_garden;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Guider {
    private static AtomicBoolean accept = new AtomicBoolean(false);
    private Set<Gate> gates = new HashSet<>();

    public static void on() {
        accept.set(true);
    }

    public static void off() {
        accept.set(false);
    }

    public static AtomicBoolean getAccept() {
        return accept;
    }

    public Set<Gate> getGates() {
        return gates;
    }

    public void addGate(Gate gate) {
        this.gates.add(gate);
    }

    public int getIns() {
        return gates.stream().mapToInt(x -> x.getIn().get()).sum();
    }

}
