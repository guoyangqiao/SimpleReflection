package 数组;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/22/16.
 */
public class TestFinal {
    public static void main(String[] args) {
        ((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i);
                Thread.yield();
            }
        }).run();
        System.out.println("=====================");
        ((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i);
                if (i % 25 == 0) Thread.yield();
            }
        }).run();
        System.out.println("=====================");
        ((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i);
            }
        }).run();
        System.out.println("+++++++++++++++++++++++++");
//        double[][] erweishuangjingdu = erweishuangjingdu(2, 2, 3, 6);
//        System.out.println(Arrays.deepToString(erweishuangjingdu));
//        String s = Arrays.deepToString(new int[3][3][3]);
//        System.out.println(s);
    }

    private static int pala() {

        return 1;
    }

    private static double[][] erweishuangjingdu(int x, int y, double min, double max) {
        double[][] doubles = new double[x][y];
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles[i].length; j++) {
                doubles[i][j] = (Math.random() * (max - min)) + min;
            }
        }
        return doubles;
    }
}