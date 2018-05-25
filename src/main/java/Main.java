import network.InetAddressTest;
import nio.FileAttributes;
import nio.FileReader;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        try {
            InetAddressTest.doIt();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
