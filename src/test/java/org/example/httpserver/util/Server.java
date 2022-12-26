package org.example.httpserver.util;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {

    public static HttpServer server;


    public static void createHttpServer(Integer port, String path) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        HttpContext context = server.createContext("/" + path); //change path to desirable
        context.setHandler(Server::handleRequest);
        server.start();
    }

    public static void downServer() {
        checkServer();
        server.stop(0);
    }

    private static void checkServer() {
        if (server == null) {
            throw new NullPointerException("Server is not running");
        }
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String content = getReturnString();
        if (content != null) {
            exchange.sendResponseHeaders(200, content.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }
    }

    private static String getReturnString() {
        return "{\"data\":\"123\"}";
    }
}
