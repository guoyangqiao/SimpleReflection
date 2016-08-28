package a_a;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class ServiceImp implements Service {
    private ServiceImp() {
    }

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    public static ServiceFactory getFactory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImp();
        }
    };
}