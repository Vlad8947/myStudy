package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {

    public void getAttributes (String fileName) {

        Path filePath = Paths.get(fileName);

        /** Index is a level of PathName */
        filePath.getName(0);

        Path filePath1 = Paths.get(filePath.toAbsolutePath().toString());

        /*check.txt*/
        System.out.println(filePath);
        /*D:\Program Files\JavaCode\myStudy\check.txt*/
        System.out.println(filePath1);
        /*
        Program Files
        JavaCode
        myStudy
        check.txt
        */
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(filePath1.getName(i));
            }
        } catch (Exception e) {

        }

        try {

            Files.isHidden(filePath);
            Files.isWritable(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BasicFileAttributes basicFileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);

            basicFileAttributes.isDirectory();
            basicFileAttributes.isRegularFile();// обычный файл
            basicFileAttributes.isSymbolicLink(); // символическая ссылка
            basicFileAttributes.lastModifiedTime();
            basicFileAttributes.size();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
