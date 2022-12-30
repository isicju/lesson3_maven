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
        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
    }

    @Test
    public void compareGetElementFroTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE END 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareGetElementFromTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGGING 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK CONTAINS ELEMENT 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            String s = "abc";
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(s);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(s);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
    }
    @Test
    public void compareCheckAddElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT FROM BEGGING 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareCheckAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT FROM MIDDLE 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareCheckAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT TO THE END 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareCheckDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM BEGGING 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareCheckDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM MIDDLE 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
    }
    @Test
    public void compareCheckDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM END 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
    @Test
    public void compareCheckDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM LIST 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
    }


}
