package klass.pp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class tea {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("klass.ViolateAccess");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Object o = aClass.newInstance();
        for (Method m : declaredMethods) {
            m.setAccessible(true);
            m.invoke(o);
        }
    }
}
