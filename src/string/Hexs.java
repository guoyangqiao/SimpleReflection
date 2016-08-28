package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/14/16.
 */
public class Hexs {


    public static void readBinaryToHex(final byte[] data) {

        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) result.append(String.format("%1$05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        int n = 0;
        byte[] buf = new byte[1024 * 4];
        String fileName = "/Users/guoyangqiao/idea/think/out/production/think/string/Hexs.class";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int read = fileInputStream.read(buf);
        readBinaryToHex(Arrays.copyOfRange(buf, 0, read));
    }


}
