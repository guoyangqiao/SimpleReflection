package 多线程;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/23/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("==============");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        daemonThread.setDaemon(true);
        daemonThread.setDaemon(false);
        daemonThread.start();
        Thread.sleep(5000);
        //因为main线程是非守护线程,所以daemonThread可以一直运行,但当main线程退出后,剩下的都是守护线程
        //JVM内只剩下守护线程时退出
    }
}
