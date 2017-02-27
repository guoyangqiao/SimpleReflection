package JUC;

import utils.NineUtils;

import java.util.concurrent.Phaser;

/**
 * function 1
 * 实现CyclicBarrier
 * function 2
 * 实现CountDownLatch
 * function 3
 * 实现并驾齐驱,一起向前
 */
public class TestPhaser {

    static char[][] vector = {
            "浩荡离愁白日斜".toCharArray(),
            "吟鞭东指即天涯".toCharArray(),
            "落红不是无情物".toCharArray(),
            "化作春泥更护花".toCharArray()
    };


    public static void main(String[] args) throws InterruptedException {
        concurrentCalculateVector();
    }

    private static void usePhaseAsCyclicBarrier() {
        int amountOfRunner = 5;
        Phaser phaser = new Phaser(amountOfRunner);
        System.out.println("作诗速度赛开始, 所有选手就位??");
        for (int i = 0; i < amountOfRunner; i++) {
            new Thread(
                    () -> {
                        long id = Thread.currentThread().getId();
                        System.out.println(id + " 进入比赛状态");
                        phaser.arriveAndAwaitAdvance();
                        System.out.println(id + " 万马齐喑究可哀, 我劝天公重抖擞");

                    }
            ).start();
        }
    }

    private static void userPhaseAsCountDownLatch() {
        Phaser phaser = new Phaser();
        phaser.register();
        System.out.println("driving happy....? car broken, find some help");
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(
                    () -> {
                        phaser.register();
                        String name = "wheel fixer " + finalI;
                        if (finalI == 2) {
                            NineUtils.sleepSeconds(5);
                        }
                        System.out.println(name + " finish fixing wheel[" + finalI + "]");
                        phaser.arriveAndDeregister();
                    }


            ).start();
        }
        System.out.println(phaser);
        int i = phaser.arriveAndAwaitAdvance();
        System.out.println(phaser);
        System.out.println("happy driving again!!! " + i);
    }

    private static void concurrentCalculateVector() {
        Phaser phaser = new Phaser(vector.length);
        for (int i = 0; i < vector.length; i++) {
            int finalI = i;
            new Thread(() -> {
                StringBuilder builder = new StringBuilder();
                for (char j : vector[finalI]) {
                    builder.append(j);
                    System.out.println(phaser.getPhase() + "->" + builder.toString());
                    phaser.arriveAndAwaitAdvance();
                }
                phaser.arriveAndDeregister();
                System.out.println(phaser.getPhase());
            }, "[calculator-" + i + "]").start();
        }
    }
}
