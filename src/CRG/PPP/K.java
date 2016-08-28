package CRG.PPP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/28/16.
 */
public abstract class K<T extends K<T>> {

    abstract T dangdang(T t);

    T delegate(T t) {
        return dangdang(t);
    }
}

class KT extends K<KT> {
    @Override
    KT dangdang(KT kt) {
        return null;
    }

    public static void main(String[] args) {
        KT kt = new KT();
        kt.delegate(kt);
        List<String> strings = Collections.checkedList(new ArrayList<String>(), String.class);
    }
}
