package generic_typa;

import java.util.Iterator;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class 斐波那契迭代组合装 implements Iterable<Integer> {
    private int size = 0;
    private int point = 2;

    public 斐波那契迭代组合装(int size) {
        this.size = size;
    }

    private Fibonacci fibonacci = new Fibonacci();

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public Integer next() {
                point++;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        斐波那契迭代组合装 斐波那契迭代组合装 = new 斐波那契迭代组合装(10);
        System.out.println(1);
        System.out.println(1);
        for (int x : 斐波那契迭代组合装) {
            System.out.println(x);
        }

    }
}
