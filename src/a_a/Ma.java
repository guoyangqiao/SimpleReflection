package a_a;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class Ma {

    public static void serviceComsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceComsumer(ServiceImp.getFactory);
    }
}
