package base64;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

/**
 * Created by guoyangqiao on 27/02/2017.
 */
public class TestBase64 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("/Users/guoyangqiao/yaojing_61202_1087067_content.zip"));
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        boolean b = Objects.deepEquals(bytes, decode);
        byte[] encode = Base64.getUrlEncoder().encode(bytes);
        System.out.println(new String(encode));
        byte[] encode1 = Base64.getMimeEncoder().encode(bytes);
        String x = new String(encode1);
        System.out.println(x);
        System.out.println(x.replace("\n", "").replace("\r", "").equals(s));
    }
}
