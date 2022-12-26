package org.example.httpserver;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationWithHttpServerTest extends DefaultTest {

    @Test
    @DisplayName("Checks that have connection with resource")
    public void isNoConnectionWithSite() {
        String resourceURL = "http://a:1111/users";
        RuntimeException exception = assertThrows(IllegalStateException.class, () -> IntegrationWithHttpServer.createList(resourceURL));
        assertEquals("Cannot connect with resource", exception.getMessage());
    }

    @Test
    @DisplayName("Checks that resource has data ")
    public void isNoDataInSite() {
        assertThrows(NullPointerException.class, () -> IntegrationWithHttpServer.checkNPE(null));
    }

    @Test
    @DisplayName("Checks that resource has data in body ")
    public void isNoDataInSiteBody() {
        ResponseEntity<String> response = null;
        assertThrows(NullPointerException.class, () -> IntegrationWithHttpServer.checkNPE(response));
    }

    @Test
    @DisplayName("Checks that have connection with resource and create list")
    public void createList() {
        String resourceURL = "http://185.106.92.99:8080/users";
        List<IntegrationWithHttpServer.Person> expectedList = Arrays.asList(
                new IntegrationWithHttpServer.Person("James", 12L, 31),
                new IntegrationWithHttpServer.Person("Peter", 13L, 32),
                new IntegrationWithHttpServer.Person("John", 14L, 23),
                new IntegrationWithHttpServer.Person("Mary", 15L, 35)
        );
        Assertions.assertEquals(expectedList, IntegrationWithHttpServer.createList(resourceURL));
    }

    @Test
    @DisplayName("Checks that have connection with resource and create list from CSV format")
    public void createListFromCSV() {
        String resourceURL = "http://185.106.92.99:8080/users?format=csv";
        List<IntegrationWithHttpServer.Person> expectedList = Arrays.asList(
                new IntegrationWithHttpServer.Person("James", 12L, 31),
                new IntegrationWithHttpServer.Person("Peter", 13L, 32),
                new IntegrationWithHttpServer.Person("John", 14L, 23),
                new IntegrationWithHttpServer.Person("Mary", 15L, 35)
        );
        Assertions.assertEquals(expectedList, IntegrationWithHttpServer.createListCSV(resourceURL));
    }
}