package org.example.myhttpserver;


import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    public static boolean getRequest() {
        String query = "http://127.0.0.1:8500";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(250);
            connection.setConnectTimeout(250);
            connection.connect();
            System.out.println("The request succeeded!");
            System.out.println("HTTP response code: " + connection.getResponseCode());
            return HttpURLConnection.HTTP_OK == connection.getResponseCode();

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return false;
    }
}
