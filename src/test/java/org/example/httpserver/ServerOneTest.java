package org.example.httpserver;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import static org.example.httpserver.ServerOne.getReturnString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerOneTest extends DefaultTest {

    @DisplayName("Starting server")
    @BeforeEach
    public void serverOneStart() throws IOException {
        ServerOne.startServerOne();
    }

    @DisplayName("Check if response on client equals to http-server data")
    @Test
    public void responseDataEquity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8500/", String.class);
        String responseBody = response.getBody();
        assertEquals(responseBody, getReturnString());
    }

}
