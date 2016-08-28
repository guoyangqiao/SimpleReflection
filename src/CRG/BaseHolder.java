package CRG;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/27/16.
 */
public class BaseHolder<T> {

    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    void shout() {
        System.out.println(t.getClass().getName());
    }
}

class SubType extends BaseHolder<SubType> {
    public static void main(String[] args) {
        SubType subType = new SubType();
        SubType subType2 = new SubType();
        subType.setT(subType2);
        subType.shout();
    }
}

class Other {
}

class BasciOther extends BaseHolder<Other> {
    public static void main(String[] args) {
        BasciOther basciOther = new BasciOther();
        BasciOther basciOther1 = new BasciOther();
        basciOther.setT(new Other());
        basciOther1.setT(basciOther.getT());
        basciOther.shout();
    }
}