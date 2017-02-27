package utils;

/**
 * 传说九尾狐有九条命
 * Created by guoyangqiao on 27/02/2017.
 */
public class NineUtils {

    public static void sleepSeconds(Number number) {
        try {
            Thread.sleep((long) (number.doubleValue() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
