package stat;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class A {

    private static int Aa = 2;

    private static class Inner {
        private static int a;

        private static int getA() {
            return 1;
        }

        private static class InnerInner {
            static int x = 10;
            int a = Inner.getA();
            C c = new C();
            int b = Inner.a;
            int d = A.Aa;
        }
    }

    private static class C {
        public static void getB() {
            Inner.getA();
        }

        static int d = Inner.InnerInner.x;
    }

    static int z = Inner.InnerInner.x;

    public static void main(String[] args) {
        Inner.InnerInner innerInner = new Inner.InnerInner();
    }
}