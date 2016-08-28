package generic_type_bound;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/21/16.
 */
public class Mian {

    static class caisegoua extends Dog implements shantie, Color {

        @Override
        public void color() {

        }

        @Override
        public void shantie90() {

        }
    }

    public static void main(String[] args) {
        caisegou<caisegoua> caisegouacaisegou = new caisegou<>(new caisegoua());
        String s = caisegouacaisegou.toString();
        System.out.println(s);
    }
}

interface Color {
    void color();
}

class Dog {
    public void dog() {

    }
}

interface shantie {
    void shantie90();

}

class caisegou<T extends Dog & shantie & Color> {
    private T t;

    public caisegou(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "caisegou{" +
                "t=" + t +
                '}';
    }
}
