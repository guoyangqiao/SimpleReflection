package JUC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guoyangqiao on 11/03/2017.
 */
public class TestLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("开始计算元素个数");
                if (objects.size() == 0) {
                    System.out.println("list为空 等待元素收集完成");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("元素个数:" + objects.size());
            } finally {
                lock.unlock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
        lock.lock();
        try {
            System.out.println("开始收集元素");
            for (int i = 0; i < 100; i++) {
                objects.add(new Object());
            }
            System.out.println("收集元素完成");
            condition.signal();
            System.out.println("唤醒计算线程-1");
        } finally {
            System.out.println("唤醒计算线程-2");
            lock.unlock();
        }
    }
}
