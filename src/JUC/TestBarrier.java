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
 * 注册的任务数到达指定数量就同时开始
 * 特点
 * 1. 注册的任务需要达到指定量
 * 2. 所有注册的任务近似同时执行
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
