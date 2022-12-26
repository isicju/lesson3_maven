package org.example.httpserver;

import org.example.DefaultTest;
import org.example.httpserver.util.Server;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegrationTest extends DefaultTest {

    private final static Integer PORT = 19840;
    private final static String PATH = "1984";
    RestTemplate restTemplate = new RestTemplate();

    @BeforeAll
    @DisplayName("CreateServer")
    public void createServer() throws IOException {
        Server.createHttpServer(PORT, PATH);
    }

    @Test
    @DisplayName("Checks that server has data")
    public void hasDataOnServer() {
        String response = getResponse();
        assertEquals("{\"data\":\"123\"}", response);
    }

    @Test
    @DisplayName("Checks that server has data. Duplicate")
    public void hasDataOnServerDuplicate() {
        String response = getResponse();
        assertEquals("{\"data\":\"123\"}", response);
    }

    @Nullable
    private String getResponse() {
        return restTemplate.getForEntity("http://localhost:" + PORT + "/" + PATH, String.class).getBody();
    }


    @Test
    @AfterAll
    @DisplayName("Check that server after test  is down")
    public void checkServer() {
        Server.downServer();
        assertThrows(ResourceAccessException.class, this::getResponse);
    }
}
