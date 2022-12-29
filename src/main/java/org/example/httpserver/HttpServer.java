package org.example.httpserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        final String RESOURCE_URL = "http://185.106.92.99:8080/users";
        final String RESOURCE_URL_WITH_FORMAT = "http://185.106.92.99:8080/users?format=csv";

        List<ServerUser> users = JsonToListOfPojo(getServerRequestJsonString(RESOURCE_URL));

        String[] arrayTest = getServerRequestJsonString(RESOURCE_URL_WITH_FORMAT).split(",|;");
        List<ServerUser> usersCsv = getListOfServerUsers(arrayTest);

    }

    public static List<ServerUser> getListOfServerUsers(String[] metadata) {
        List<ServerUser> usersCsv = new ArrayList<>();
        for (int i = 0; i < metadata.length; i+=3) {
            ServerUser user = new ServerUser(
                    metadata[i+2],
                    Integer.parseInt(metadata[i]),
                    Integer.parseInt(metadata[i+1]));
            usersCsv.add(user);
        }
        return usersCsv;
    }

    public static String getServerRequestJsonString(String resourceUrl) {
        if (resourceUrl == null) throw new NullPointerException();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response.getBody();
    }

    public static List<ServerUser> JsonToListOfPojo (String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<>(){});
    }

}
