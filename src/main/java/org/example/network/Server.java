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
            StringBuilder stringBuilder = new StringBuilder();
            while (receivedMessage != null && !receivedMessage.isEmpty()){
                receivedMessage = in.readLine();
                stringBuilder.append(receivedMessage);
            }
            System.out.println(stringBuilder);

//            if ("hello server".equals(receivedMessage)) {
//                System.out.println("server received hello server word!");
//            } else if ("exit".equals(receivedMessage)) {
//                System.out.println("received message from client to shutdown..");
//                out.println("server will be shutdown");
//                close();
//                break;
//            } else {
//                System.out.println("server received not hello server word!");
//                out.println("unrecognised greeting");
//            }

            out.println("HTTP/1.1 200 OK\n" +
                    "Server: nginx\n" +
                    "Date: Fri, 02 Oct 2015 11:54:02 GMT\n" +
                    "Connection: close\n" +
                    "Vary: Accept-Encoding\n" +
                    "P3P: CP=\"Tumblr's privacy policy is available here:\n" +
                    "\thttps://www.tumblr.com/policy/en/privacy\"\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h1>My First Heading</h1>\n" +
                    "<p>My first paragraph.</p>\n" +
                    "<iframe width=\"420\" height=\"315\"\n" +
                            "src=\"https://www.youtube.com/embed/jifUJrYPZQQ\">\n" +
                            "</iframe>" +
                    "</body>\n" +
                    "</html>");
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
        server.start(4444);
    }

}
