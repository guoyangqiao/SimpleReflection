package localOrUnnameClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/8/16.
 */
public class Tesa {

    public List<Context> dada() {
        return new ArrayList<Context>() {
            {
                class       ApplicationContext implements Context {
                }
                for (int i = 0; i < 100; i++) {
                    add(new ApplicationContext());
                }
            }
        };
    }

    public List<Context> tata() {
        return new ArrayList<Context>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Context() {
                    });
                }
            }
        };
    }

    public HashMap getHa() {
        return new HashMap() {
            {
                System.out.println("haah");
                doSomethingThatHashMapCanNotDo();
            }


            public void doSomethingThatHashMapCanNotDo() {
                this.put("ccc", "ddd");
            }

            @Override
            public String toString() {
                doSomethingThatHashMapCanNotDo();
                return this.get("ccc").toString();
            }

        };
    }

    public static void main(String[] args) {
        Tesa tesa = new Tesa();
        List<Context> dada = tesa.dada();
        List<Context> tata = tesa.tata();
        System.out.println("");

        HashMap ha = tesa.getHa();
//        ha.doSomethingThatHashMapCanNotDo();
        System.out.println(ha.get("ccc"));
        System.out.println(ha.toString());
    }

}

interface Context {

}