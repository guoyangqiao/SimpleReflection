package 高级容器;

import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/14/16.
 */
public class Soout {
//    public static void main(String[] args) {
//        List arr = new ArrayList<Integer>() {
//            {
//                for (int i = 0; i < 10; i++) {
//                    add((int) (Math.random() * i));
//                }
//            }
//        };
//        List lnk = new LinkedList<Integer>() {
//            {
//                for (int i = 0; i < 10; i++) {
//                    add((int) (Math.random() * i));
//                }
//            }
//        };
//        long l = System.currentTimeMillis();
//        Collections.sort(arr);
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1 - l);
//        Collections.sort(lnk);
//        System.out.println(System.currentTimeMillis() - l1);
//
//    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(null);
        System.out.println(objects.size());
    }
}
