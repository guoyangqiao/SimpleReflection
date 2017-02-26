package JUC;

import java.util.concurrent.Phaser;

/**
 * Created by guoyangqiao on 26/02/2017.
 */
public class TestPhaser {

    static int[][] vector = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
    };


    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        for (int i = 0; i < vector.length; i++) {
            int finalI = i;
            new Thread(() -> {
                phaser.register();
                int sum = 0;
                String name = Thread.currentThread().getName();
                for (int j : vector[finalI]) {
                    sum += j;
                    System.out.println("[" + name + "]进行了一次加法, 值=" + j + " 和=" + sum);
                    System.out.println(phaser);
                }
            }, "[calculator-" + i + "]").start();
        }
    }
}
