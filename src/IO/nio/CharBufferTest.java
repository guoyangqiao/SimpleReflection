package IO.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/24/16.
 */
public class CharBufferTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        FileChannel channel = new FileInputStream("/Users/guoyangqiao/1.txt").getChannel();
        int read = channel.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array(), 0, read, Charset.forName("utf-8")));
    }
}
