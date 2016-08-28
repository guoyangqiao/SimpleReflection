import java.util.Arrays;
import java.util.Iterator;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/12/16.
 */
public class AIterable implements Iterable<String> {
    String[] s = {"ad", "dsa"};
    private int count = 0;

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return count < s.length;
            }

            @Override
            public String next() {
                return s[count++];
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
//        AIterable strings = new AIterable();
//        for (String x : strings) {
//            System.out.println(x);
//        }
        String[] s = {"ad", "dsa"};
        testite(Arrays.asList(s));
    }

    static <T> void testite(Iterable<T> t) {
        for (T o : t) {
            System.out.println(o);
        }
    }
}

class AnotherIter implements Iterator<String> {


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
