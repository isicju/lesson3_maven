package org.example.httpserver;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URL;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(SimpleHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String filePath = exchange.getRequestURI().getPath().replaceFirst("/", "");
        String content = getFileAsString(filePath);
        if (content != null) {
            exchange.sendResponseHeaders(200, content.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }
    }

    private static String getFileAsString(String filePath) {
        try {
            URL resource = SimpleHttpServer.class.getClassLoader().getResource(filePath);
            return FileUtils.readFileToString(new File(resource.toURI()), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }


}
