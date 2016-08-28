package whatTheHell;

import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/26/16.
 */
class Gen<T> {
    void d(T t) {
    }
}

class testHell<T> {

    void method1(List<? extends fruto> t) {
        fruto o = t.get(0);
//        t.add(new fruto());
    }

    void method2(List<? super fruto> t) {
        t.add(new appla());
        t.add(new fruto());
//        fruto o1 = t.get(0);
    }

    void method3(List<fruto> tt) {
        tt.add(new fruto());
        fruto fruto = tt.get(0);
    }

    public static void main(String[] args) {

    }
}

class fruto {

}

class appla extends fruto {

}