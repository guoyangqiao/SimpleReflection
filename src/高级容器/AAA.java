package 高级容器;

import java.util.PriorityQueue;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/24/16.
 */
public class AAA {

    static class MyInteger extends Number implements Comparable<MyInteger> {

        private int x;

        public MyInteger(int x) {
            this.x = x;
        }

        @Override
        public int intValue() {
            return x;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }

        @Override
        public int compareTo(MyInteger o) {
            return (x < o.intValue()) ? 1 : ((x == o.intValue()) ? 0 : -1);
        }

        @Override
        public String toString() {
            return x + "";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<MyInteger> uncomparables = new PriorityQueue<>();
        uncomparables.offer(new MyInteger(6));
        uncomparables.offer(new MyInteger(16));
        uncomparables.offer(new MyInteger(23));
        uncomparables.offer(new MyInteger(12));
        uncomparables.offer(new MyInteger(42));
        uncomparables.offer(new MyInteger(123));
        uncomparables.offer(new MyInteger(9));
        uncomparables.offer(new MyInteger(126));
        uncomparables.offer(new MyInteger(78));
        System.out.println(uncomparables.toString());
        System.out.println("==================================================");
        while (uncomparables.peek() != null) {
            System.out.println("[" + uncomparables.poll());
            System.out.println(uncomparables);
            System.out.println();
        }
    }

    static int getRandom() {
        return (int) (Math.random() * 100);
    }
}

class Uncomparable implements Comparable<Uncomparable> {
    int i;

    public Uncomparable(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(Uncomparable o) {
        return this.i < o.i ? -1 : (this.i == o.i ? 0 : 1);
    }

    @Override
    public String toString() {
        return
                "i=" + i;
    }

    public static void main(String[] args) {
        long lang = -1111111111111111111L;
        System.out.println(Long.toBinaryString(lang));
        System.out.println(Long.toBinaryString(lang >>> 32));
        long l = lang ^ (lang >>> 32);
        System.out.println(Long.toBinaryString(l));
        System.out.println(l);
        System.out.println((int)l);
        System.out.println(0B00100100101011110000010001101101);
    }
}