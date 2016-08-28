package adaptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 说明: 正向 反向 迭代
 * <p>
 * Created by guoyangqiao on 4/13/16.
 */
public class DoubleIterator<T> extends ArrayList<T> {


    @Override
    public Iterator<T> iterator() {
        return reverseIterator();
    }


    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            private int current = (size() - 1);

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }
        };
    }

    public static void main(String[] args) {
        DoubleIterator<String> doubleIterator = new DoubleIterator<>();
        doubleIterator.add("ko");
        doubleIterator.add("li");
        doubleIterator.add("audi");
        doubleIterator.add("safari");
        Collections.shuffle(doubleIterator);
        Iterator<String> iterator = doubleIterator.reverseIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String xx : doubleIterator) {
            System.out.println(xx);
        }
    }
}


