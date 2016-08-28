package generic_typa;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class Fibonacci implements Generator<Integer> {

    private static final int first = 1;
    private static final int second = 1;

    private int thisOne = first;
    private int nextOne = second;

    @Override
    public Integer next() {
        int temp = thisOne + nextOne;
        thisOne = nextOne;
        nextOne = temp;
        return temp;
    }
}
