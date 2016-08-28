import interfaca.Destination;
import interfaca.Wrapping;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class InnerClass {

    public Wrapping wa(int x) {
        return new Wrapping(x) {
            {
                System.out.println("init");
            }

            private int y = x;

            public int getY() {
                return super.getY() * x;
            }
        };
    }

    public Destination getD() {
        return new Destination() {
            @Override
            public void dd() {

            }

            @Override
            public String read() {
                return null;
            }

            @Override
            public void write(String a) {

            }
        };
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        Wrapping wa = innerClass.wa(3);
        int y = wa.getY();
        System.out.println(y);
    }


}


