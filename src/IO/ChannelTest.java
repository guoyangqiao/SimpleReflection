package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/27/16.
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2222);
        FileChannel channel = new FileInputStream("/Users/guoyangqiao/2.txt").getChannel();
        channel.read(byteBuffer);
        char x;
        while ((x = byteBuffer.getChar()) != 0) {
            System.out.println(x);
        }
        System.out.println("==========================");
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put("萨顶顶,wasabi");

        while ((x = byteBuffer.getChar()) != 0) {
            System.out.println(x);
        }
        DoubleBuffer put = byteBuffer.asDoubleBuffer().put(213D).put(678D);
        double c;
        while ((c = byteBuffer.getDouble()) != 0) {
            System.out.println(c);
        }
        while ((x = byteBuffer.getChar()) != 0) {
            System.out.println(x);
        }
        byteBuffer.flip();
        byte[] array = byteBuffer.array();
        for(byte z: array){
            System.out.println(z);
        }
    }
}