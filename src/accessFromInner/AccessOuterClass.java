package accessFromInner;

import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/1/16.
 */
public class AccessOuterClass {

    class wa {

    }

    private AccessOuterClass() {

    }

    private static final AccessOuterClass ACCESS_OUTER_CLASS = new AccessOuterClass();

    public void doSomething() {
        System.out.println("do do do");
    }

    public static Innerla<AccessOuterClass> getAccessClass() {
        return new Innerla<AccessOuterClass>() {

            @Override
            public AccessOuterClass getR() {
                return ACCESS_OUTER_CLASS;
            }
        };
    }

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("asd");
        strings.add("f");
        strings.add("asd");
        strings.add("asd");
        strings.remove("f");
        System.out.println(1);
    }

}

