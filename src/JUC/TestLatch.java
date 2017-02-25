package JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by guoyangqiao on 25/02/2017.
 */
public class TestLatch {
    public static void main(String[] args) {
        CountDownLatch vehicleReady = new CountDownLatch(4);
        Runnable vehicleDriver = () -> {
            System.out.println("driving into parker, wait for fix completed");
            try {
                vehicleReady.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("everything is ready, lets go!");
        };
        final int[] wheelNumberGener = {0};
        Runnable vehicleFixer = () -> {
            long id = Thread.currentThread().getId();
            int wheelNumber = ++wheelNumberGener[0];
            System.out.println(id + " fixing wheel" + wheelNumber);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(id + " fixing wheel " + wheelNumber + " finished");
            vehicleReady.countDown();
        };

        new Thread(vehicleDriver).start();


        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();

    }
}