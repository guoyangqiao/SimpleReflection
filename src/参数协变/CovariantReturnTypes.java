package 参数协变;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/6/16.
 */
public class CovariantReturnTypes {
    public static void main(String[] args) {

    }

    void test(DerivedGetter d) {
        Derived derived = d.get();
        Base base = d.get();
    }
}


class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    @Override
    Derived get();
}