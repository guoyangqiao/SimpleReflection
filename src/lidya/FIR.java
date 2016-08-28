package lidya;

import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/29/16.
 */
public class FIR {
}

interface Processor<T, E extends Exception> {
    T process(T list) throws E;
}

class IntegerProcessor<T, E extends Exception> implements Processor<Object, ClassCastException> {

    @Override
    public Integer process(Object list) throws RuntimeException {
        return list != null && list instanceof Integer ? (int) list * 10 : 0;
    }
}

class StringProcessor implements Processor<Object, ClassCastException> {

    @Override
    public String process(Object list) throws ClassCastException {
        return list != null && list instanceof String ? String.valueOf(list).concat("/") : "";
    }
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    T processAll(T ts) throws E {
        for (Processor<T, E> processor : this) {
            processor.process(ts);
        }
        return ts;
    }

}