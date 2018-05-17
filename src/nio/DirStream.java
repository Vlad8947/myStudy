package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirStream {

    public void doIt (String dirName) {

        try (   DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName))   ){

            for ( Path dirPath: directoryStream) {

                System.out.println(dirPath);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /** With filter */

        DirectoryStream.Filter<Path> dirFilter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if(Files.isDirectory(entry)) return true;
                return false;
            }
        };

        try (   DirectoryStream<Path> directoryStream =
                        Files.newDirectoryStream(Paths.get(dirName), /**filter*/ dirFilter)   ){

            for ( Path dirPath: directoryStream) {
                System.out.println(dirPath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
