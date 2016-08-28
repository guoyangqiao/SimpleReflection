package p205p23;

import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/1/16.
 */
public class B {

    U[] us = new U[10];

    public void storeU(U u, int where) {
        us[where] = u;
    }

    public void nullU(int where) {
        us[where] = null;
    }

    public void ott() {
        for (U u : us) {
            u.u1();
            u.u2();
            u.u3();
        }
    }

    public static void main(String[] args) {
        B b = new B();
        ArrayList<A> as = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            as.add(new A());
            b.storeU(as.get(i).getU(), i);
        }
        b.nullU(2);
    }
}
