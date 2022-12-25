package org.example.httpserver;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServerOne {

    public static void main(String[] args) {
    }

    public static void startServerOne() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);//change port to desirable
        HttpContext context = server.createContext("/"); //change path to desirable
        context.setHandler(ServerOne::handleRequest);
        server.start();
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

    public static String getReturnString() {
        return "{\"data\":\"123\"}";
    }

}
