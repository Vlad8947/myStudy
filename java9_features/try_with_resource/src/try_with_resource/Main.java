package try_with_resource;

import java.io.*;

public class Main {

    public static void in7version() {
//        i can't create resource variable and then give it to try
//        OutputStream outputStream = new FileOutputStream("test.dat");
        try (OutputStream outputStream =
                     new FileOutputStream("test.dat");
        ) {
            outputStream.write("old try".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void now() throws IOException {
        OutputStream outputStream = new FileOutputStream("test.dat");
        try (outputStream) {
            outputStream.write("new try".getBytes());
        }
    }

}
