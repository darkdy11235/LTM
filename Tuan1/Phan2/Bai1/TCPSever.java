package org.example.Tuan1.Phan2.Bai1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPSever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at " + new Date());

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected from " + socket.getInetAddress());
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(new Date().toString());
            } catch (IOException ex) {
                System.out.println("Error in connection: " + ex.getMessage());
            }
        }
    }
}
