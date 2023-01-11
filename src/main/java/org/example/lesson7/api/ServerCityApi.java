package org.example.lesson7.api;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import static org.example.utils.DataUtil.getFileAsByteArray;

public class ServerCityApi {

    public static CityApi cityService = CityApi.getInstance();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(ServerCityApi::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String filePath = exchange.getRequestURI().getPath().replaceFirst("/", ""); //getRequestURI() - возвращение полного пути, getPath() - возвращение строкового представления пути, replaceFirst() - замена / на ""
        if (filePath.contains("cities")) {
            byte[] cityBytes = parseData();
            sendResponse(exchange, cityBytes);
        } else {
            byte[] content = getFileAsByteArray(filePath);
            sendResponse(exchange, content);
        }
    }

    public static byte[] parseData() {
        return new Gson().toJson(cityService.getAllCities()).getBytes(StandardCharsets.UTF_16);
    }

    public static void sendResponse(HttpExchange exchange, byte[] byteArray) throws IOException {
        exchange.sendResponseHeaders(200, byteArray.length);
        OutputStream os = exchange.getResponseBody();
        os.write(byteArray);
        os.close();
    }
}
