package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileReader {

    public void read (String fileName) {

        // Or another stream/channel
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(Paths.get(fileName)); ){
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);
            int count;
            while(true) {
                count = seekableByteChannel.read(byteBuffer);
                if (count != -1) {
                    byteBuffer.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.println( (char) byteBuffer.get() );
                    }
                } else {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void mappedRead(String fileName) {
        try (
                FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                        Paths.get(fileName),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE
                )
        ) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 128);
            for (int i = 0; i < mappedByteBuffer.limit(); i++) {
                mappedByteBuffer.get();
                mappedByteBuffer.put((byte) ('a'));
            }

        } catch (InvalidPathException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(Paths.get("D:/toServer.txt"));
             FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                     Paths.get("D:/toServer_2.txt"),
                     StandardOpenOption.WRITE,
                     StandardOpenOption.READ,
                     StandardOpenOption.CREATE
             )
        ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(500);
            byte[] nullableArray = new byte[500];
//            for(int i = 0; i < 500; i++) {
//
//            }
            int bytesNum = 0;
            while ((bytesNum = seekableByteChannel.read(byteBuffer)) != -1) {
                if (bytesNum != 500) {
                    byteBuffer.rewind();
                    byteBuffer = ByteBuffer.wrap(byteBuffer.array(), 0, bytesNum);
                }
                byteBuffer.rewind();
                fileChannel.write(byteBuffer);
                byteBuffer.rewind();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
