package org.example.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        closeConnection();
        return resp;
    }

    public void closeConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        org.example.network.Client client = new org.example.network.Client();
        client.startConnection("127.0.0.1", 70);
        System.out.println("sending hello server");
        String response = client.sendMessage("hello server");
//        String response = client.sendMessage("exit");
        System.out.println("client received from server: " + response);
    }

}
