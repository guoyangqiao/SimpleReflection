package klass;

import java.util.LinkedHashMap;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/18/16.
 */
public class SuperClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<? super LinkedHashMap> aClass = LinkedHashMap.class.getSuperclass();
        Object o = aClass.newInstance();
    }
}
