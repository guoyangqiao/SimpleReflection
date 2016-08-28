package p199.p15;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class Haha {

    public NoDefClass getNoClass(int x) {
        return new NoDefClass(x) {
            {
                System.out.println("inited " + x);
            }
        };
    }

    public static void main(String[] args) {
        Haha haha = new Haha();
        NoDefClass noClass = haha.getNoClass(3);
        int x = noClass.getX();
        System.out.println(x);
    }
}
