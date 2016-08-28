package capture;


import genericMode.Holder;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/27/16.
 */
public class Capture {


    static <T> void f1(Holder<T> t) {
        T t1 = t.getT();
        t1.getClass().getName();
    }

    static void f2(Holder<?> t1) {
        f1(t1);
    }

    public static void main(String[] args) {
//        Holder ih = new Holder<Integer>(1);
//        f1(ih);
//        f2(ih);
//
//        Holder holder = new Holder(new Object());
//        f2(holder);
//        f1(holder);
//        Holder<?> ge = new Holder<Double>(1D);
//        f2(ge);
        System.out.println('A'-'a');
    }


}


class ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(ComparablePet o) {
        System.out.println(o.getClass().getSimpleName());
        System.out.println(this.getClass().getSimpleName());
        return 0;
    }
}

class Cat extends ComparablePet implements Comparable<ComparablePet> {
    public static void main(String[] args) {
        Cat cat = new Cat();
        int i = cat.compareTo(new ComparablePet());
    }
}