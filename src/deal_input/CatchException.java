package deal_input;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/15/16.
 */
public class CatchException {

    public CatchException() {
    }

    public static void main(String[] args) throws Exception {
        String regex = "((\\w+\\.)+.*Exception:)|(at .*\\(.*\\.[a-z]+:[0-9]+\\))";
        Scanner scanner = new Scanner(new FileInputStream("~/Desktop/log.2016_04_14"));
        Pattern compile = Pattern.compile(regex);
        StringBuilder wholeException = new StringBuilder();
        int line = 0;
        while (scanner.hasNextLine()) {
            line++;
            String singleLine = scanner.nextLine();
            if (compile.matcher(singleLine).find()) {
                wholeException.append(line).append("-").append(singleLine).append("\n");
            }
        }
        System.out.println(wholeException.toString());
    }

}
