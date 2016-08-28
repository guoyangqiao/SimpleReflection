package IO.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/26/16.
 */
public class MapChannel {
    public static void main(String[] args) throws Exception {
        FileChannel channel = new FileOutputStream("/Users/guoyangqiao/raf.dat").getChannel();
        FileLock lock = channel.tryLock();
        System.out.println(lock == null);
        lock.release();
    }
}