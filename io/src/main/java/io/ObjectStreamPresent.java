package io;

import java.io.*;

public class ObjectStreamPresent {

    private static final String fileName = "object_stream_test.dat";

    public static void main(String[] args) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            // The class Person must be Serializable
            Person tom = new Person("Tomas", 34, 1.68, false);
            oos.writeObject(tom);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            Person tom = (Person) ois.readObject();
            System.out.println(tom);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
