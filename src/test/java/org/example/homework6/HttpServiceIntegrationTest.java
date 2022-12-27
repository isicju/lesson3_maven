package org.example.homework6;

import org.example.DefaultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.homework6.HttpServiceIntegration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpServiceIntegrationTest extends DefaultTest {

    @Test
    @DisplayName("Checks that list of persons is created from JSON")
    void createListTest() {
        List<Person> targetList = new ArrayList<>();
        targetList.add(new Person("James", 12, 31));
        targetList.add(new Person("Peter", 13, 32));
        targetList.add(new Person("John", 14, 23));
        targetList.add(new Person("Mary", 15, 35));
        List<Person> testList = createPersonsList();
        assertEquals(targetList, testList);
    }

    @Test
    @DisplayName("Checks that list of persons is created from CSV")
    void createListTestCSV() {
        List<Person> targetList = new ArrayList<>();
        targetList.add(new Person("James", 12, 31));
        targetList.add(new Person("Peter", 13, 32));
        targetList.add(new Person("John", 14, 23));
        targetList.add(new Person("Mary", 15, 35));
        List<Person> testList = createPersonsListCSV();
        assertEquals(targetList, testList);
    }
}
