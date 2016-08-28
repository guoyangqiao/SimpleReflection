package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/23/16.
 */
public class ProcessCmd {
    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream(new File("/Users/guoyangqiao/1.html")).getChannel();

        File file = new File("/Users/guoyangqiao/2.html");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileChannel out = new FileOutputStream(file).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2048);
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }
}