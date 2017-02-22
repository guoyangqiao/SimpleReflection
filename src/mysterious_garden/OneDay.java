package mysterious_garden;

import java.util.Set;

public class OneDay {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(6<<1);
//        Guider guider = new Guider();
//        guider.addGate(new Gate("east"));
//        guider.addGate(new Gate("wast"));
//        guider.addGate(new Gate("north"));
//        guider.addGate(new Gate("south"));
//        Guider.on();
//        System.out.println("garden enable");
//        peopleComing(guider.getGates(), guider);
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println("garden disable");
//        Guider.off();
    }

    private static void peopleComing(Set<Gate> gates, Guider guider) {
        new Thread(
                () -> gates.forEach(gate -> new Thread(
                        () -> {
                            while (Guider.getAccept().get()) {
                                gate.in();
                                try {
                                    Thread.sleep(5);
                                } catch (InterruptedException e) {
                                }
                            }
                            System.out.println(gates);
                            System.out.println(guider.getIns());
                        }
                ).start())
        ).start();
    }
}
