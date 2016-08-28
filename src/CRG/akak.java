package CRG;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/28/16.
 */

interface SelfBoundedInter<T extends SelfBoundedInter<T>> {
    void toStrina();
}

interface DerivedSelfBounded extends SelfBoundedInter<DerivedSelfBounded> {
}

class D implements SelfBoundedInter<D> {

    @Override
    public void toStrina() {
        System.out.println(this.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        D d = new D();
        d.toStrina();
    }
}


class Fa {
    Fa get() {
        return this;
    }
}

class So extends Fa {
    So get() {
        return this;
    }
}

class Sky {
    public static void main(String[] args) {
        Fa fa = new Fa().get();
        So so = new So().get();
    }
}