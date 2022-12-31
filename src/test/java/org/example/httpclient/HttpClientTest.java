package org.example.httpclient;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest extends DefaultTest {


    @Test
    public void simpleTest() throws IOException {
        String urlForTesting = "localhost:777/users";
        HttpClient client = new HttpClient(urlForTesting);

        HttpServerForTest serverForTest = new HttpServerForTest("users", 777);
        String responseFromServer = "[{\"name\":\"James\",\"id\":12,\"age\":31},{\"name\":\"Peter\",\"id\":13,\"age\":32}]";

        serverForTest.setResponse(responseFromServer);

        List<HttpClient.User> users =  client.createUserList();

        assertEquals(users.size(),2);
        assertEquals(users.get(0).getName(),"James");
    }

}
