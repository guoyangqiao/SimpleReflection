package IO.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by guoyangqiao on 26/02/2017.
 */
public class TranslateBiggyPiggy {
    private final static String piggy = "/Users/guoyangqiao/VirtualBox VMs/ubunut12.04/u.vdi";
    private final static String home = "/Users/guoyangqiao/Desktop/vvv.ttl";
    private static final int sizeOfBuffer = 1024 * 1024 * 16;
    private static final int splitSize = 1024 * 1024 * 8;

    public static void main(String[] args) throws IOException, InterruptedException {
        long before = System.currentTimeMillis();
        copyPiggy();
        long after = System.currentTimeMillis();
        System.out.println("method cost:" + (after - before));
        System.out.println("do size equal?? " + getIfFileSizeEqual());
        Files.delete(Paths.get(home));
    }

    private static boolean getIfFileSizeEqual() throws IOException {
        return Files.size(Paths.get(piggy)) == Files.size(Paths.get(home));
    }

    private static void copyPiggy() throws IOException, InterruptedException {
        rafPartitionCopy();
    }
    //unstable time cost. from 1min to 27s but cost too much
    private static void rafPartitionCopy() throws IOException, InterruptedException {
        long piggySize = Files.size(Paths.get(piggy));
        int partitions = (int) ((piggySize + splitSize) / splitSize);
        CountDownLatch allTaskDone = new CountDownLatch(partitions);
        final AtomicLong[] currentPosition = {new AtomicLong(0)};
        File file = new File(home);
        if (!file.exists()) {
            file.createNewFile();
        }
        for (int i = 0; i < partitions; i++) {
            new Thread(() -> {
                System.out.println("Start");
                try (RandomAccessFile raPiggy = new RandomAccessFile(piggy, "r"); RandomAccessFile raHome = new RandomAccessFile(home, "rw")) {
                    long startPosition = currentPosition[0].getAndAdd(splitSize);
                    long nextStartPosition = startPosition + splitSize;
                    long size = nextStartPosition > piggySize ? piggySize - startPosition : splitSize;
                    System.out.println("the current start position of map is " + startPosition + ", the size is " + size);
                    MappedByteBuffer map = raPiggy.getChannel().map(FileChannel.MapMode.READ_ONLY, startPosition, size);
                    raHome.getChannel().write(map, startPosition);
                    System.out.println("end");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    allTaskDone.countDown();
                }
            }).start();
        }
        allTaskDone.await();
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