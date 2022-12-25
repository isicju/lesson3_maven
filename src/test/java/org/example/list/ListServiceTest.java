package org.example.list;

import org.example.DefaultTest;
import org.example.lists.ListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ListServiceTest extends DefaultTest {

    ListService<String> arrayBasedService;
    ListService<String> linkedListBasedService;

    @BeforeEach
    public void populateArrays() {
        System.out.println("Initializing array and linked list by put 1M records inside.");
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            String uuid = UUID.randomUUID().toString();
            arrayList.add(uuid);
            linkedList.add(uuid);
        }
        System.out.println("Initialization complete");
        arrayBasedService = new ListService<>(arrayList);
        linkedListBasedService = new ListService<>(linkedList);
    }

    @Test
    public void compareGetElementFroTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareGetElementFroTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE END 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(arrayBasedService.getSize());
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(arrayBasedService.getSize());
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

}
