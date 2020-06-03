package network;

import java.io.IOException;
import java.net.*;

public class DatagramTest {

    public static void server (InetSocketAddress inetSocketAddress, byte[] buffer) {

        try ( DatagramSocket datagramSocket = new DatagramSocket(inetSocketAddress.getPort()); ){

            datagramSocket.send(new DatagramPacket(buffer, buffer.length, inetSocketAddress));

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void client (InetSocketAddress inetSocketAddress, byte[] buffer) {

        try ( DatagramSocket datagramSocket = new DatagramSocket(inetSocketAddress); ){

            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

            datagramSocket.receive(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
