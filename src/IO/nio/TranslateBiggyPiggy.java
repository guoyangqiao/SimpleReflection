package IO.nio;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by guoyangqiao on 26/02/2017.
 */
public class TranslateBiggyPiggy {
    private final static String piggy = "/Users/guoyangqiao/VirtualBox VMs/ubunut12.04/u.vdi";
    private final static String home = "/Users/guoyangqiao/Desktop/vvv";
    private static final int sizeOfBuffer = 1024 * 1024 * 16;
    private static final int splitSize = 1024 * 1024 * 512;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            long before = System.currentTimeMillis();
            copyPiggy();
            long after = System.currentTimeMillis();
            System.out.println("method cost:" + (after - before));
            System.out.println("do size equal?? " + getIfFileSizeEqual());
            Files.delete(Paths.get(home));
        }
    }

    private static boolean getIfFileSizeEqual() throws IOException {
        return Files.size(Paths.get(piggy)) == Files.size(Paths.get(home));
    }

    private static void copyPiggy() throws IOException {
    }

    //28900 around. using direct accelerated 7%, as 26700 around
    private static void BufferCopy() throws IOException {
        System.out.println("buffer size using " + sizeOfBuffer);
        ByteBuffer buffer = ByteBuffer.allocateDirect(sizeOfBuffer);
        FileInputStream fileInputStream = new FileInputStream(piggy);
        FileChannel inCh = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(home);
        FileChannel outCh = fileOutputStream.getChannel();
        while (inCh.read(buffer) != -1) {
            buffer.flip();
            outCh.write(buffer);
            buffer.clear();
        }
        inCh.close();
        outCh.close();
    }

    //failed the maxium size = 2^31-1
    private static void usingTransfer() throws IOException {
        FileInputStream piggyInput = new FileInputStream(piggy);
        long size = Files.size(Paths.get(piggy));
        System.out.println("file size=" + size);
        long l = piggyInput.getChannel().transferTo(0, size, new FileOutputStream(home).getChannel());
        System.out.println("transferred " + l);
    }

    //45849 around
    private static void copyByFilesUtil() throws IOException {
        Files.copy(Paths.get(piggy), new BufferedOutputStream(new FileOutputStream(home)));
    }

}