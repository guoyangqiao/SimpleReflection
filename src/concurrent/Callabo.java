package concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callabo {

    //    static final public String x = "123";
//    final static public String x = "123";
    public final static String x = "123";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> submit = executorService.submit(() -> {
            Thread.sleep(3000L);
            return Thread.currentThread().getId();
        });
        try {
            System.out.println(submit.isDone());
            System.out.println(submit.cancel(true));
            System.out.println(submit.isCancelled());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
//        ye();
    }

    private static void ye() {
        ArrayList<Future<Long>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(() -> {
                long id = Thread.currentThread().getId();
                Thread.sleep((long) (Math.random() * 10));
                return id;
            }));
        }
        futures.forEach((x) -> {
            if (x.isDone()) {
                try {
                    System.out.println(x.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            } else {
                Long aLong = null;
                try {
                    aLong = x.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(aLong);
            }
        });
        executorService.shutdown();
    }
}
