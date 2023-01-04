package org.example.online;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.example.lesson7.api.CityApi;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import static org.example.utils.DataUtil.getFileAsByteArray;

public class MyHttpServer {

    public static CityApi cityService = CityApi.getInstance();

    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(MyHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String filePath = exchange.getRequestURI().getPath().replaceFirst("/", "");
        if (filePath.contains("cities")) {
            String jsonCities = new Gson().toJson(cityService.getAllCities());
            byte[] cityBytes = jsonCities.getBytes(StandardCharsets.UTF_16);
            exchange.sendResponseHeaders(200, cityBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(cityBytes);
            os.close();
        } else {
            byte[] content = getFileAsByteArray(filePath);
            exchange.sendResponseHeaders(200, content.length);
            OutputStream os = exchange.getResponseBody();
            os.write(content);
            os.close();
        }
    }
}
