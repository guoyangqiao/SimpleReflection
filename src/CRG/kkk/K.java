package CRG.kkk;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/28/16.
 */
public class K {
}

class Base {
}

class Derived extends Base {
}

class OrdGet {
    void set(Base b) {

    }
}

class DeGet {
    void set(Derived d) {

    }

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DeGet deGet = new DeGet();
//        deGet.set(base);
        deGet.set(derived);
    }
}