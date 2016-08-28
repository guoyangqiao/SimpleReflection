package IO;

import java.io.*;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/23/16.
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(new File("/Users/guoyangqiao/123.txt")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String x;
        while ((x = bufferedReader.readLine()) != null && !"".equals(x)) {
            System.out.println(x);
        }
    }
}
