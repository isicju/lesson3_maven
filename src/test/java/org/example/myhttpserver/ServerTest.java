package org.example.myhttpserver;

import com.sun.net.httpserver.HttpServer;
import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServerTest extends DefaultTest {
    @DisplayName("HTTP request validation")
    @Test
    public void requestValidation() throws Throwable {
        Server.startServer();
        Assertions.assertTrue(HttpRequest.getRequest());
        Server.stopServer();
    }
}
