package JUC;

import utils.NineUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * function 1
 * 当前线程组运行->等待其他线程组完成->当前线程组继续运行
 * function 2
 * 实现CyclicBarrier
 */
public class TestLatch {
    public static void main(String[] args) {
        waitAndNotify();
    }

    private static void workAsCyclicBarrier() {
        int amountOfWorker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(amountOfWorker);
        for (int i = 0; i < amountOfWorker; i++) {
            new Thread(() -> {
                NineUtils.sleepSeconds(Math.random());
                System.out.println(System.currentTimeMillis() + " 等待全部worker准备好");
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "工作结束");
            }).start();
        }
    }

    private static void waitAndNotify() {
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
        new Thread(vehicleDriver).start();
        NineUtils.sleepSeconds(1);

        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();
        new Thread(vehicleFixer).start();
    }
}