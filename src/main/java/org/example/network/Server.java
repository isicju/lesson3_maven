package org.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        while (true) {
            System.out.println("Server started...");
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String receivedMessage = in.readLine();

            if ("hello server".equals(receivedMessage)) {
                System.out.println("server received hello server word!");
            } else if ("exit".equals(receivedMessage)) {
                System.out.println("received message from client to shutdown..");
                out.println("server will be shutdown");
                close();
                break;
            } else {
                System.out.println("server received not hello server word!");
                out.println("unrecognised greeting");
            }
            close();
        }
    }

    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(70);
    }

}
