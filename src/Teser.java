import java.io.OutputStreamWriter;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/25/16.
 */
public class Teser {

    private void getParameter(String abc, int b, Integer c) {
        System.out.println(abc + b + c);
    }

    public static void main(String[] args) throws Exception {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        outputStreamWriter.write("abc");
        outputStreamWriter.close();
    }
}
