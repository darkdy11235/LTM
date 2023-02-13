package org.example.Tuan2.Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    // A list to keep track of all connected clients
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Chat Server Started on Port 8080");

        // Listen for incoming connections and accept them
        while (true) {
            Socket client = server.accept();
            // Add the new client to the list of connected clients
            clients.add(client);
            // Spawn a new thread for the client
            new ClientHandler(client).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a BufferedReader to read messages from the client
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String message;
                // Read messages from the client
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Broadcast the message to all connected clients
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Remove the client from the list of connected clients
                clients.remove(socket);
                try {
                    // Close the socket
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            // Write the message to all connected clients
            for (Socket client : clients) {
                try {
                    PrintWriter writer = new PrintWriter(
                            client.getOutputStream(), true);
                    writer.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
