import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/25/16.
 */
public class Teser {

    private void getParameter(String abc, int b, Integer c) {
        System.out.println(abc + b + c);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        for (Parameter a : Teser.class.getDeclaredMethod("getParameter", String.class, int.class, Integer.class).getParameters()) {
            System.out.println(a.getName());
        }
    }

    private void did() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        integers.stream().filter(x -> x > 50).forEach(System.out::println);
    }
}
