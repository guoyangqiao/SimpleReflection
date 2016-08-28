package 参数协变;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/6/16.
 */
public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter getter = g.get();
        GenericGetter gx = g.get();
    }
}


interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {

}
