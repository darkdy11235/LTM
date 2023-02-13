package org.example.Tuan2.Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    private String host;  // the hostname or IP address of the chat server
    private int port;     // the port number to connect to the chat server

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // start the chat client
    public void start() {
        try {
            // connect to the chat server
            Socket socket = new Socket(host, port);
            System.out.println("Connected to Chat Server");

            // setup input and output streams for communication with the server
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);

            // get the user's name
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = scan.nextLine();

            // start a new thread to receive messages from the server
            new Thread(new Receiver(reader)).start();

            // read messages from the user and send them to the server
            while (true) {
                String message = scan.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                writer.println(name + ": " + message);
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host: " + host);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in I/O");
            e.printStackTrace();
        }
    }

    // inner class to handle receiving messages from the server
    private static class Receiver implements Runnable {
        private BufferedReader reader;

        public Receiver(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            try {
                // receive messages from the server
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // main method to start the chat client
    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 8080);
        client.start();
    }
}
