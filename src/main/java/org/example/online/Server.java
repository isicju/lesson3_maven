package org.example.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(70);
        Socket clientSocket = serverSocket.accept();

        PrintWriter clientDestinationOut = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String messageFromClient = in.readLine();

        if ("hello server".equals(messageFromClient)) {
            clientDestinationOut.println("server received hello server word!");
        } else if ("exit".equals(messageFromClient)) {
            clientDestinationOut.println("received message from client to shutdown..");
            clientDestinationOut.println("server will be shutdown");
            //
        } else {
            clientDestinationOut.println("server received not hello server word!");
            clientDestinationOut.println("unrecognised greeting");
        }

        in.close();
        clientDestinationOut.close();
        clientSocket.close();
        serverSocket.close();

    }

}
