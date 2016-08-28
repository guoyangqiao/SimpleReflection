package 用类型标签和反射创建某个类的对象;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/21/16.
 */
public class U {
    private int i;

    public U(int i) {
        this.i = i;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        getTypeInstance<U> ugetTypeInstance = new getTypeInstance<>(U.class);
        U instance = ugetTypeInstance.getInstance();
        System.out.println(instance.toString());

        getTypeInstance<Integer>[] hua = (getTypeInstance<Integer>[]) new Object[100];
        hua[0] = new getTypeInstance<>(Integer.TYPE);

    }

    @Override
    public String toString() {
        return "U{" +
                "i=" + i +
                '}';
    }
}


class getTypeInstance<X> {

    private Class<X> kind;

    public getTypeInstance(Class<X> kind) {
        this.kind = kind;
    }

    X getInstance() {
        try {
            Constructor<X> cons = kind.getDeclaredConstructor(int.class);
            cons.setAccessible(true);
            return cons.newInstance(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(3320%79);
    }
}

class Euclid {
    public static void main(String[] args) {
        int function = function(1970, 1066);
        System.out.println("=============");
        System.out.println(function);
    }

    public static int function(int a, int b) {
        if (b == 0) return a;
        else {
            System.out.println(a / b);
            return function(b, a % b);
        }
    }
}