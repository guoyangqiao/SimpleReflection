package override_inner_class;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/8/16.
 */
public class A {
    private York york;

    public A() {
        this.york = new York();
    }

    class York {
        public York() {
            System.out.println("A.YORK");
        }

        public void YY() {
            System.out.println("yyy");
        }


    }

    protected void changYork(York y) {
        york = y;
    }

    public void Y() {
        this.york.YY();
    }


}

class AA extends A {
    class York extends A.York {
        public York() {
            System.out.println("AA.YORK");
        }

        public void YY() {
            System.out.println("ZZZ");
        }
    }

    public AA() {
        changYork(new York());
    }

    public static void main(String[] args) {
        AA aa = new AA();
        aa.Y();
    }
}