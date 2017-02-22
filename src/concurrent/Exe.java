package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 20/11/2016.
 */
public class Exe {

    public static void main(String[] args) {
        Setup.main();
    }
}

class Producer implements Runnable {
    private static int i = 0;
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    Object produce() throws InterruptedException {
        System.out.println(++i);
        return new Object();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue queue;

    private String name;

    Consumer(String consumer, BlockingQueue q) {
        name = consumer;
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    void consume(Object x) {
        System.out.println(name);
    }
}

class Setup {
    public static void main() {
        BlockingQueue q = new LinkedBlockingDeque<>();
        Producer p = new Producer(q);
        Consumer c1 = new Consumer("consumer1", q);
        Consumer c2 = new Consumer("consumer2", q);
        Consumer c3 = new Consumer("consumer3", q);
        Consumer c4 = new Consumer("consumer4", q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c4).start();
        new Thread(c3).start();
        new Thread(c2).start();
    }
}
