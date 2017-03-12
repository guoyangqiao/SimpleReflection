package IO.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by guoyangqiao on 11/03/2017.
 */
public class Model {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Selector selector = Selector.open();

        SocketChannel connectChannel = SocketChannel.open();
        connectChannel.configureBlocking(false);
        connectChannel.register(selector, SelectionKey.OP_CONNECT, buffer);

        int readyKeySize = selector.select();
        if (readyKeySize > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey connChannelKey = iterator.next();
                try {
                    if (connChannelKey.isAcceptable()) {

                    }
                    if (connChannelKey.isConnectable()) {

                    }
                    if (connChannelKey.isReadable()) {

                    }
                    if (connChannelKey.isWritable()) {

                    }
                } finally {
                    iterator.remove();
                }
            }
        }
        selector.wakeup();
        selector.close();
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            key.channel().close();
        }
    }
}
