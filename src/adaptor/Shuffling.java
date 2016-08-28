package adaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/13/16.
 */
public class Shuffling {

    public void one() {
        String[] dd = "what is that ? it is a car".split(" ");
        List<String> strings = Arrays.asList(dd);
        Collections.shuffle(strings);
        System.out.println(strings);
        System.out.println(Arrays.toString(dd));
    }

    public void two() {
        String[] dd = "what is that ? it is a car".split(" ");
        List<String> strings = Arrays.asList(dd);
        ArrayList<String> strings1 = new ArrayList<>(strings);
        Collections.shuffle(strings1);
        System.out.println(strings1);
        System.out.println(Arrays.toString(dd));
    }

    public static void main(String[] args) {
        Shuffling shuffling = new Shuffling();
        shuffling.one();
        shuffling.two();
    }

}
