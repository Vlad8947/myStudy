package io;

import java.io.*;

public class BufferedStreamPresent {

    public static final String fileName = "buffered_stream_test.dat";

    public static void main(String[] args) {

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
             OutputStreamWriter osw = new OutputStreamWriter(bos);) {

            osw.write("Это\nprosto\nkosmos");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
                InputStreamReader isr = new InputStreamReader(bis);) {

            bis.mark(1000);

            isr.skip(2);
            while (isr.ready()) {
                System.out.print((char) isr.read());
            }

            System.out.println();
            System.out.println();

            bis.reset();
            while(bis.available() > 0) {
                System.out.print((char) bis.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
