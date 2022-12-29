package org.example.httpserver;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.*;
import java.util.*;

public class HttpServer {

    public static List<User> convertFromCSV() throws Exception {
        URL url = new URL("http://185.106.92.99:8080/users?format=csv");
        String[] arrayUsers = getData(url).split(";");
        List<User> users = new ArrayList<>();
        for (String arrayUser : arrayUsers) {
            String[] temp = arrayUser.split(",");
            users.add(new User(temp[2], Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        return users;
    }


    public static List<User> convertFromJson() {
        try {
            String data = getData(new URL("http://185.106.92.99:8080/users"));
            Gson gson = new Gson();
            return gson.fromJson(data, new TypeToken<List<User>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getData(URL url) throws Exception {
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
