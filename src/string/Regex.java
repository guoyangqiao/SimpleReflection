package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/14/16.
 */
public class Regex {

    public static void main(String[] args) {
        String abc = "-12334";
        String regex = "(-|\\+)?\\d+";

        boolean matches = abc.matches(regex);
        System.out.println(matches);

        abc.replaceAll("", "");
        abc.replaceFirst("", "");
        abc.matches("");
        abc.split("");

        String stat = "This is a body with a number.";

        boolean matches1 = stat.matches("^[A-Z].*[a-z]\\.$");
        System.out.println(matches1);


        String knight = "Then , when you hava found the shrubbery, you must " +
                "cut down the mightiest tree in the frost...888 with... a herring!";
        String[] split = knight.split("(the|you)");
        for (String x : split) {
            System.out.println(x);
        }
        System.out.println(knight);
        System.out.println(knight.replaceAll("[[AEIO]Uaeiou]", "_"));
        System.out.println(knight.replaceAll("[^AEIOUaeiou]", "_"));
        System.out.println(knight.replaceAll("\\s", "_"));
        System.out.println(knight.replaceAll("\\S", "_"));
        System.out.println(knight.replaceAll("\\d", "_"));
        System.out.println(knight.replaceAll("\\D", "_"));
        System.out.println(knight.replaceAll("\\w", "_"));
        System.out.println(knight.replaceAll("\\W", "_"));
        boolean matches2 = "".matches("T+");
        boolean matches3 = Pattern.compile("T*").matcher("").matches();
        System.out.println(matches3);
        System.out.println(matches2);

        Matcher abc1 = Pattern.compile("abc").matcher("abcdfmwkenqwenwjdlsajdlasbcabcbabvbcbcabacbabvcasdadbascbabc");
        while (abc1.find()) {
            System.out.println("[" + abc1.start() + "-" + abc1.end() + ")");
        }


        String groupMatch = "abc def ghi klm";
        Matcher matcher = Pattern.compile("(abc)(def)(ghi)").matcher(groupMatch);
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            System.out.println(":)");
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + "-" + matcher.group(i));
            }
        }

        Pattern p = Pattern.compile("thing|people|dogs");
        Matcher m = p.matcher("one thing two people three dogs in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "think");
        }
        System.out.println(sb.toString());
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

}