package deal_input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/15/16.
 */
public class Haro {

    public static void main(String[] args) {
        String regex = "(^(\\w+\\.)+.*Exception:)|(at (\\w+\\.)+.*:[0-9]+\\))";
        String temp =
                "        at java.net.URL.<init>(URL.java:585)\n" +
                        "        at java.net.URL.<init>(URL.java:482)\n" +
                        "        at java.net.URL.<init>(URL.java:431)";
        Matcher m = Pattern.compile(regex).matcher(temp);
        if (m.find()) {
            System.out.println(m.group());
        }
    }

}
