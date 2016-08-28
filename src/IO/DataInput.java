package IO;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/23/16.
 */
public class DataInput {
    public static void main(String[] args) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("/Users/guoyangqiao/a.java"));
        while (true) {
            System.out.println(dataInputStream.readUTF());
        }
    }
}
