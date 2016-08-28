package accessFromInner;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/1/16.
 */
public class TestClasa {

    public static void main(String[] args) {
        Innerla<AccessOuterClass> accessClass = AccessOuterClass.getAccessClass();
        AccessOuterClass r = accessClass.getR();
        r.doSomething();
        AccessOuterClass.wa wa = r.new wa();


    }
}
