package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopy {

    public void doIt (Path source, Path target) throws IOException {


        /*
        *  StandardCopyOption.REPLACE_EXISTING - перезапись прежднего файла
        *  StandardCopyOption.COPY_ATTRIBUTES - копирование атрибутов файла
        *  StandardCopyOption.NOFOLLOW_LINKS - не следовать символическим ссылкам
        */
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

    }
}
