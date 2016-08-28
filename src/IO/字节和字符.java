package IO;

import java.io.*;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/21/16.
 */
public class 字节和字符 {
    public static void main(String[] args) {
        int bufferSize = 50;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream("/Users/guoyangqiao/a.java"));
            out = new BufferedOutputStream(new FileOutputStream("/Users/guoyangqiao/b.txt"), bufferSize);

            byte[] bytes = new byte[bufferSize];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}