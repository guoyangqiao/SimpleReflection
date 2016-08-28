package IO.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/23/16.
 */
public class Begin {

    public static void main(String[] args) throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.asLongBuffer().put(97);
        allocate.reset();
        CharBuffer charBuffer = allocate.asCharBuffer();
        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.get());
        }
    }
}
