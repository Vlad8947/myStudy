package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void doIt () throws UnknownHostException {

        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        inetAddress = InetAddress.getByName("www.yandex.ru");
        System.out.println(inetAddress);

        InetAddress[] inetAddresses = InetAddress.getAllByName("www.yandex.ru");
        for (InetAddress ia: inetAddresses) {
            System.out.println(ia);
        }

    }

}
