package delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
interface Interface {
    void doSomething();
}

class     RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("RealObject do something");
    }
}

public class DynamicProxy implements InvocationHandler {

    private Object proxied;

    public DynamicProxy(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("class=" + proxy.getClass().getSimpleName());
        System.out.println("method=" + method.getName());
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        method.invoke(proxied, args);
        return null;
    }

}

class Instance {
    public static void main(String[] args) {
        Interface in = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxy(
                        new RealObject()));
        in.doSomething();
    }
}