package JUC;

/** */

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrier类似于CountDownLatch也是个计数器，
 * 不同的是CyclicBarrier数的是调用了CyclicBarrier.await()进入等待的线程数，
 * 当线程数达到了CyclicBarrier初始时规定的数目时，所有进入等待状态的线程被唤醒并继续。
 * CyclicBarrier就象它名字的意思一样，可看成是个障碍，
 * 所有的线程必须到齐后才能一起通过这个障碍。
 * CyclicBarrier初始时还可带一个Runnable的参数，
 * 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。
 */
public class TestBarrier {

    public static void main(String[] args) {
        final int[] racerSeedGenerator = {0};
        final Instant[] raceStartTime = new Instant[1];
        CyclicBarrier barrierGate = new CyclicBarrier(5, () -> System.out.println(raceStartTime[0].atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " all racer are ready to compete racing!!!"));
        Runnable racer = () -> {
            int racerSeed = racerSeedGenerator[0]++;
            System.out.println("racer " + racerSeed + " is ready, waiting for other racer ready");
            try {
                raceStartTime[0] = Instant.now();
                barrierGate.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("racer" + racerSeed + " reach the end");
        };
        new Thread(racer).start();
        new Thread(racer).start();
        new Thread(racer).start();
        new Thread(racer).start();
//        new Thread(racer).start();

        System.out.println(barrierGate.isBroken());
    }
}
