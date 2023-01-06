package org.example.httpserver;

import org.junit.Before;
import org.junit.Test;

public class HttpClientTest {
    
    @Test
    public void checkСonversionToJson() {
        
    }
    @Test
    public void checkСonversionToCSV() {
    
    }
    @Test
    public void checkResponseFromServer() {
         HttpServer.receptionHttp("http://185.106.92.99:8080/users?format=csv");
        
    }
}
