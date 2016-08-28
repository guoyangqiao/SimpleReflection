package generic_typa;

import java.util.Iterator;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int size;

    public IterableFibonacci(int size) {
        this.size = size;
    }

    private class FibonacciIterator implements Iterator<Integer> {
        private int length = size;
        private int point = 2;

        @Override
        public boolean hasNext() {
            return point < length;
        }

        @Override
        public Integer next() {
            point++;
//            IterableFibonacci.this.next(); 这个将调用IterableFibonacci的next()
            return IterableFibonacci.super.next();//这个将调用Fibonacci的next()
        }
    }

    @Override
    public Integer next() {
        return 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    public static void main(String[] args) {
        IterableFibonacci iterableFibonacci = new IterableFibonacci(10);
        for (Integer x : iterableFibonacci) {
            System.out.println(x);
        }
    }
}
