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
import java.nio.file.Files;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(SimpleHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String filePath = exchange.getRequestURI().getPath().replaceFirst("/", "");
        byte[] content = getFileAsString(filePath);
        if (content != null) {
            exchange.sendResponseHeaders(200, content.length);
            OutputStream os = exchange.getResponseBody();
            os.write(content);
            os.close();
        }
    }

    private static byte[] getFileAsString(String filePath) {
        try {
            URL resource = SimpleHttpServer.class.getClassLoader().getResource(filePath);
            File file = new File(resource.toURI());
            return Files.readAllBytes(file.toPath());
        } catch (Exception e) {
            return null;
        }
    }


}
