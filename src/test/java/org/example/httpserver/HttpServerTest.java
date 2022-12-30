package org.example.httpserver;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpServerTest {

    private static List<Users1> users = new ArrayList<>();

    private static String getStaticContent(String path) {
        String filePath = extractUrl(path).trim();
        URL resource = HttpServerTest.class.getClassLoader().getResource(filePath);
        try {
            return resource == null ? null : FileUtils.readFileToString(new File(resource.toURI()), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    private static String getUsers() {
        return new Gson().toJson(users);
    }

    private static void initUsers() {
        User peter = new User("Peter", 1);
        User john = new User("John", 2);
        User mary = new User("Mary", 3);
        users = List.of(peter, john, mary);
    }

    public static void main(String[] args) throws Exception {
        initUsers();

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");

        while (true) {
            try {
                Socket connection = server.accept();
                try (
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        Writer serverWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                ) {
                    String url = bufferedReader.readLine();
                    String httpBodyResponse = url.contains("user") ? getUsers() : getStaticContent(url);

                    serverWriter.write("HTTP/1.1 200 OK\r\n"
                            + "Connection: close \r\n"
                            + httpBodyResponse + "\r\n");
                    serverWriter.flush();
                    System.out.println("DONE");
                }
            } catch (Exception e) {
                System.out.println("Exception occured: " + e.getMessage());
            }
        }
    }

    private static String extractUrl(String path) {
        try {
            return path.split("GET")[1].split("HTTP")[0].substring(2);
        } catch (Exception e) {
            System.out.println("invalid path to file: " + e.getMessage());
            throw new IllegalArgumentException("Invalid path in url" + path);
        }
    }


}
