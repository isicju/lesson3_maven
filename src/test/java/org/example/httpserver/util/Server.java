package org.example.httpserver.util;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {

    private final HttpServer server;
    private String body = "";

    public Server(Integer port, String path) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        HttpContext context = server.createContext("/" + path); //change path to desirable
        context.setHandler(this::handleRequest);
        server.start();
    }

    public void downServer() {
        server.stop(0);
    }

    private void handleRequest(HttpExchange exchange) throws IOException {
        String content = getReturnString();
        if (content != null) {
            exchange.sendResponseHeaders(200, content.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }
    }

    private String getReturnString() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
