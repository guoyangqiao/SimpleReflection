package inner_class_extend;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/8/16.
 */
public class ExtendFromInnerClass {
    class F {
        class G {

        }
    }
}

class ExtendF extends ExtendFromInnerClass.F {
    public ExtendF(ExtendFromInnerClass efic) {
        efic.super();
    }
}

class ExtendG extends ExtendFromInnerClass.F.G {
    public ExtendG(ExtendFromInnerClass.F f) {
        f.super();

        System.out.println("123");
    }

    public static void main(String[] args) {
        ExtendFromInnerClass extendFromInnerClass = new ExtendFromInnerClass();
        ExtendFromInnerClass.F f = extendFromInnerClass.new F();
        ExtendFromInnerClass.F.G g = f.new G();

        ExtendG extendG = new ExtendG(new ExtendF(new ExtendFromInnerClass()));
        System.out.println(extendG);
    }
}