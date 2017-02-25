package JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guoyangqiao on 25/02/2017.
 */
public class TestSemaphore {
    public static void main(String[] args) {
        AtomicInteger idGetter = new AtomicInteger(1);
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String worker = Thread.currentThread().getName();
                try {
                    semaphore.acquire();
                    System.out.println(worker + " 获取到执行许可, 开始执行任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(worker + " 释放许可");
                semaphore.release();
            }, "worker-" + idGetter.getAndAdd(1)).start();
        }
    }
}
