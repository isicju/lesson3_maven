package org.example.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requester {

    public static void main(String[] args) throws IOException {

        List<Client> clientsListJson = getClientsJson("http://185.106.92.99:8080/users");

        List<Client> clientListCsv = getClientsCsv("http://185.106.92.99:8080/users?format=csv");

        for (int i = 0; i < clientListCsv.size(); i++) {
            System.out.println(clientsListJson.get(i).equals(clientListCsv.get(i)));
        }

    }

    public static List<Client> getClientsCsv(final String url) {
        String csvResponse = GET(url);

        List<String> clientsParameters = Arrays.asList(csvResponse.strip().split(";"));
        List<Client> clientList = new ArrayList<>(clientsParameters.size());

        // Build clients out of Csv String.
        for (String clientParameter : clientsParameters) {
            List<String> clientInfo = Arrays.asList(clientParameter.split(","));
            Client client = new Client();
            client.setId(Integer.parseInt(clientInfo.get(0)));
            client.setAge(Integer.parseInt(clientInfo.get(1)));
            client.setFirstName(clientInfo.get(2));
            clientList.add(client);
        }
        return clientList;

    }


    public static List<Client> getClientsJson(String url) {
        String responseJSON = GET(url);
        JSONArray jsonArray = new JSONArray(responseJSON);

        // Making objects out of an JSONArray
        ObjectMapper objectMapper = new ObjectMapper();
        List<Client> listClientsJson = null;
        try {
            listClientsJson = objectMapper.readValue(jsonArray.toString(), new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listClientsJson;

    }

    public static String GET(String url) {
        HttpClient requester = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(url))
                .GET()
                .build();
        // Decompose GET-response to JSONArray
        HttpResponse<String> response = null;
        try {
            response = requester.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}

