package org.example.myhttpserver;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


public class Server {
    private static HttpServer server;

    static {
        try {
            server = HttpServer.create(new InetSocketAddress(8500), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startServer() throws Throwable {
        HttpContext context = server.createContext("/"); //change path to desirable
        context.setHandler(Server::handleRequest);
        server.start();
    }

    public static void stopServer(){
        server.stop(0);
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






