package org.example.httpserver;

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

public class SimpleHttpServer {

    private static CityApi cityApi = CityApi.getInstance();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(SimpleHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        byte[] responseByteArray = null;
        if (exchange.getRequestURI().getPath().contains("cities")) {
            responseByteArray = getCityData();
        } else {
            responseByteArray = getStaticData(exchange);
        }
        sendResponse(exchange, responseByteArray);
    }

    private static byte[] getCityData() {
        return (new Gson().toJson(cityApi.getAllCities())).getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] getStaticData(HttpExchange exchange) {
        String filePath = exchange.getRequestURI().getPath().replaceFirst("/", "");
        byte[] content = getFileAsByteArray(filePath);
        return content == null ? new byte[]{} : content;
    }

    private static void sendResponse(HttpExchange exchange, byte content[]) throws IOException {
        exchange.sendResponseHeaders(200, content.length);
        OutputStream os = exchange.getResponseBody();
        os.write(content);
        os.close();
    }


}
