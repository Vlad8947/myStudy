package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChanelNIO {

    public void serverSocketChanel(InetSocketAddress address) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(address);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            for (SelectionKey selectionKey: selector.selectedKeys()) {
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    /**IMPORTANT!!!*/
                    if(socketChannel == null) {
                        continue;
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                    int readedBytes = socketChannel.read(byteBuffer);
                    byte[] bytes = new byte[readedBytes];
                    byteBuffer.get(bytes, 0, bytes.length);
                    String message = new String(bytes);
                    System.out.println("Socket say: " + message);
                }
                else if (selectionKey.isWritable()) {

                }
            }
        }
    }

    public void socketChanel(InetSocketAddress inetSocketAddress) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);

    }

}
