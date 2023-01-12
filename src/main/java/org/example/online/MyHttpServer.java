package org.example.online;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import org.example.httpserver.CityApi;
import org.example.lesson7.api.UserApi;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import static org.example.utils.DataUtil.getFileAsByteArray;

class myHttpServer {
    
    private static UserApi userApi = UserApi.getInstance();
    private static CityApi City100RandomApi = CityApi.getInstance();
    
    public static void main(String[] args) throws IOException {
        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(org.example.httpserver.HttpServer::handleRequest);
        server.start();
    }
    
    static void handleRequest(HttpExchange exchange) throws IOException {
        byte[] responseByteArray = null;
        if (exchange.getRequestURI().getPath().contains("city")) {
            responseByteArray = City100RandomApi();
        } else {
            responseByteArray = getStaticData(exchange);
        }
        sendResponse(exchange, responseByteArray);
    }
    
    private static byte[] City100RandomApi() {
        return (new Gson().toJson(City100RandomApi.getOnlyFirst100cities())).getBytes(StandardCharsets.UTF_8);
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

