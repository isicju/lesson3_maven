package org.example.httpserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpServer {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://185.106.92.99:8080/users";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, "")
    }
}
