package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIp {


    public static void server (int port) {

        try ( ServerSocket serverSocket = new ServerSocket(port); ){

            Socket socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void client (String host, int port) {

        try ( Socket socket = new Socket(host, port); ){

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
