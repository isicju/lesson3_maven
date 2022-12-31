package org.example.httpclient;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServerForTest {

    private String url;
    private String response;

    HttpServerForTest(String url, int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        HttpContext context = server.createContext("/" + url);
        context.setHandler(this::handleRequest);
        server.start();
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

    public void setResponse(String response) {
        this.response = response;
    }

    private String getReturnString() {
        return response;
    }

}