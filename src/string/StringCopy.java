package string;

import java.util.Formatter;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/13/16.
 */
public class StringCopy {

    private String name;
    private Formatter formatter;

    public StringCopy(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s tht turtle is at (%d ,%d) \n", name, x, y);
    }

    public static void main(String[] args) {
        StringCopy feeling = new StringCopy("feeling", new Formatter(System.err));
        StringCopy diding = new StringCopy("diding", new Formatter(System.out));
        feeling.move(3, 5);
        diding.move(6, 3);
    }

}