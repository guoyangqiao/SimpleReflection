package night;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class SelfManageRunner implements Runnable {

    private static AtomicBoolean cc = new AtomicBoolean(false);
    private static Integer dd = 0;
    private final Thread self = new Thread(this);


    public SelfManageRunner() {
        this.self.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(Long.MAX_VALUE);
    }
//        ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                local.set(new HashMap<String, Object>() {{
//                    put("id", finalI);
//                    put("value", Thread.currentThread());
//                }});
//                System.out.println(local.get());
//
//
//            }).start();
//        }

//        int b = ccc();
//        System.out.println(b);
//
//        System.out.println(b);
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < 20; i++) {
//                System.out.println("start");
//            }
//        });
//        thread.start();
//        Thread.sleep(1000L);
//        System.out.println("2131231");
//        thread.interrupt();
//        for (int i = 0; i < 100; i++) {
//            System.out.println("ooooooooooo");
//        }


//         GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(new File("/tmp/AA/abc.gz")));
//
//         ArrayList<String> strings = new ArrayList<>();
//         for(int i=0;i<10000;i++){
//             strings.add(i+"");
//         }
//         strings.forEach(line -> {
//             System.out.println(line);
//             try {
//                 gzipOutputStream.write((line + "\n").getBytes("UTF-8"));
//             } catch (IOException e) {
//             }
//         });
//         gzipOutputStream.finish();
//         gzipOutputStream.flush();
//         gzipOutputStream.close();
//         System.out.println(MailReportStatus.open);
//
//         System.out.println("https://mail.qq.com/cgi-bin/readmail?sid=2eVXOnx7YmoIBBVN&amp;mailid=ZC4627-98uk0pSCAwtpR1YOpgSBe6c&amp;t=compose&amp;s=draft&amp;disptype=html&amp;backurl=https%3A%2F%2Fmail.qq.com%2Fcgi-bin%2Freadmail%3Ffolderid%3D3%26folderkey%3D%26t%3Dreadmail%26mailid%3DZC4627-98uk0pSCAwtpR1YOpgSBe6c%26mode%3Dpre%26maxage%3D3600%26base%3D12.5%26ver%3D13279%26sid%3D2eVXOnx7YmoIBBVN%23stattime%3D1482823335720".length());

//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                for (int ij = 0; ij < 100; ij++) {
//                    System.out.println(cc.getAndSet(!cc.get()));
//                    System.out.println(dd++);
//                }
//            }).start();

    private static int ccc() {
        int b = 3;
        try {
            b = 4;
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b = 5;
            return b;
        }
    }

    private static void abc() {
        Thread thread = Thread.currentThread();
        class L {
            boolean a;
            boolean b;
        }
        L l = new L();
        new Thread(() -> {
            System.out.println("jinru 1");
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally 1");
                l.a = true;
                if (l.b) {
                    LockSupport.unpark(thread);
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("jinru 2");
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally 2");

                l.b = true;
                if (l.a) {
                    LockSupport.unpark(thread);
                }
            }
        }).start();
        LockSupport.park();
        System.out.println("end");
    }
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        System.out.println(executorService.isShutdown());
//        int INTERVAL_TASK_QUEUE = 10;
//        int SCHEDULED_TASK_QUEUE = 2;
//        int remainSize;
//        if((remainSize = INTERVAL_TASK_QUEUE) + SCHEDULED_TASK_QUEUE !=0){
//            System.out.println(remainSize);
//        }
//        System.out.println((remainSize = INTERVAL_TASK_QUEUE) + SCHEDULED_TASK_QUEUE);
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.currentThread().sleep(10000L);
//            } catch (InterruptedException e) {
//                System.out.println("interrupted");
//                Thread.currentThread().interrupt();
//                System.out.println("loop start");
//                System.out.println("loop end");
//            }
//        });
//        thread.start();
//        Thread.sleep(2000L);
//        thread.interrupt();
//        Thread.currentThread().sleep(20);
//        System.out.println(thread.isAlive() + "-" + thread.isInterrupted());
//    }

    @Override
    public void run() {
        System.out.println("run");
    }

    enum MailReportStatus {
        open,
        click,
        bounce,
        error,
        unsubscribe

    }
}
