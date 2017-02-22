package night;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Ares {

    public static void main(String[] args) throws ParseException, InterruptedException {
        System.out.println(1);
        Ares ares = new Ares();
//        new Thread(()->{
//            ares.a(ares);
//        }).start();
        new Thread(()->{
            ares.b(ares);
        }).start();

    }

    private static synchronized void a(Ares ares) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.holdsLock(Ares.class));
        System.out.println(Thread.holdsLock(ares));
        System.out.println("a");
    }

    private  synchronized void b(Ares a) {
        System.out.println(Thread.holdsLock(this));
        System.out.println(Thread.holdsLock(Ares.class));

        System.out.println("b");
        a(a);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println("running in");
            try {
                TimeUnit.MILLISECONDS.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
            System.out.println("running out");
        }
    }
}