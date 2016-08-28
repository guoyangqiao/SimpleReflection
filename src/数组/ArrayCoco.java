package 数组;

import java.util.Arrays;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/23/16.
 */
public class ArrayCoco {
    public static void main(String[] args) {
        Integer[] ints = {1, 31, 2, 34242, 34, 32, 5, 45, 234, 231, 23, 123, 12,};
//        int[] kl = new int[ints.length];
//        System.arraycopy(ints, 0, kl, 0, ints.length);
//        System.out.println(Arrays.toString(kl));
        Arrays.sort(ints, (o1, o2) -> o1 << o2 > 0 ? -1 : 1);
        System.out.println(Arrays.toString(ints));
    }

}