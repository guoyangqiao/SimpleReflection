package class_enhance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//main
public class Teser {
    public static void main(String[] args) {
        Vehicle car = ProxyHandler.Handle(() -> System.out.println("vehicle running"));
        car.run();
        System.out.println("flag line========================");
        Person man = ProxyHandler.Handle(() -> System.out.println("a man is running"));
        man.run();
    }
}

//util
class ProxyHandler implements InvocationHandler {

    static <S> S Handle(S t) {
        return (S) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new ProxyHandler(t));
    }

    private Object t;

    private ProxyHandler(Object t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result;
        try {
            result = method.invoke(t, args);
        } finally {
            System.out.println("after");
        }
        return result;
    }
}

//interfaces
interface Person {
    void run();
}

interface Vehicle {
    void run();
}