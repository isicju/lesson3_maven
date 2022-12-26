package org.example.httpserver;

import com.google.gson.Gson;
import org.example.DefaultTest;
import org.example.httpserver.util.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegrationTest extends DefaultTest {

    private final static Integer PORT = 19840;
    private final static String PATH = "1984";
    private static final String URL = "http://localhost:19840/1984";
    private Server server;

    @BeforeAll
    @DisplayName("CreateServer")
    public void createServer() throws IOException {
        server = new Server(PORT, PATH);
    }

    @Test
    @DisplayName("Checks that server has data")
    public void hasDataOnServer() {
        List<IntegrationWithHttpServer.Person> expectedList = Arrays.asList(
                new IntegrationWithHttpServer.Person("James", 12L, 31),
                new IntegrationWithHttpServer.Person("Peter", 13L, 32),
                new IntegrationWithHttpServer.Person("John", 14L, 23),
                new IntegrationWithHttpServer.Person("Mary", 15L, 35)
        );
        String bodyJSON = new Gson().toJson(expectedList);
        server.setBody(bodyJSON);
        assertEquals(expectedList, IntegrationWithHttpServer.createList(URL));
    }

    @Test
    @DisplayName("Checks that server has data. Duplicate")
    public void hasDataOnServerDuplicate() {
        List<IntegrationWithHttpServer.Person> expectedList = Arrays.asList(
                new IntegrationWithHttpServer.Person("James", 12L, 31),
                new IntegrationWithHttpServer.Person("Peter", 13L, 32),
                new IntegrationWithHttpServer.Person("John", 14L, 23),
                new IntegrationWithHttpServer.Person("Mary", 15L, 35)
        );
        String bodyJSON = new Gson().toJson(expectedList);
        server.setBody(bodyJSON);
        assertEquals(expectedList, IntegrationWithHttpServer.createList(URL));
    }

    @Test
    @AfterAll
    @DisplayName("Check that server after test  is down")
    public void checkServer() {
        server.downServer();
        assertThrows(RuntimeException.class, () -> IntegrationWithHttpServer.createList(URL));
    }
}
