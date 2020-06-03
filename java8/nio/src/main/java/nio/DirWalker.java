package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirWalker {

    /**
     * The Class walk on directory tree
     */
    class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            /** some code with dir funtion */
            return FileVisitResult.CONTINUE;
        }

    }

    public void doIt(String dirName) {
        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
