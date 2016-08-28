package genericMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/25/16.
 */
 class Compa {

    public static void main(String[] args) {
        List<? extends Apple> aa = new ArrayList<>();
//        aa.add(new Apple());
//        aa.add(new Orange());
//        aa.add(new Fruit());
//        aa.add(new Hongfushi());

        List<? extends Fruit> cc = new ArrayList<>();
//        cc.add(new Apple());
//        cc.add(new Orange());
//        cc.add(new Fruit());
//        cc.add(new Hongfushi());

    }

}

public class Holder<T> {
    private T t;

    public Holder(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}