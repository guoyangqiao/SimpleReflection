package klass;

import java.lang.reflect.InvocationTargetException;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/17/16.
 */
public class ClassMethods {

    static final int abc = 10;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        System.out.println("---load--");
        System.out.println(Initable.bbb);
//        Class<?> aClass = Class.forName("klass.Initable");
        System.out.println("---link----");
        System.out.println(Initable.staticInt);
        System.out.println("----");
        System.out.println(Initable.staticFinalInt);
    }
}

class Initable {
    static final int bbb = 30000;
    static final int staticInt = getstatint();
    static final int staticFinalInt = getabc();
    static final int finalInt = getfinal();

    private static int getabc() {
        System.out.println("abc");
//        return ClassMethods.abc;
        return 123;
    }

    static {
        System.out.println("initable     init");
    }

    public static int getfinal() {
        System.out.println("final");
        return 343;
    }

    private static int getstatint() {
        System.out.println("get staticInt");
        return 36;
    }
}
