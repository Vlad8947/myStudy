import nio.FileAttributes;
import nio.FileReader;

public class Main {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        FileAttributes fileAttributes = new FileAttributes();

        fileAttributes.getAttributes("check.txt");

    }
}
