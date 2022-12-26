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
    public void compareGetElementFromTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle(linkedListBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareGetElementFromTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE END 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(arrayBasedService.getSize() - 1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(linkedListBasedService.getSize() - 1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }


    @Test
    public void compareGetElementFromTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGGING 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(0);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK CONTAINS ELEMENT 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement("kek");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement("kek");

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }


    @Test
    public void compareAddElementToBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT TO BEGGING 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToBegging("kek", 0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToBegging("kek", 0);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT TO MIDDLE 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle("kek", arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle("kek", linkedListBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT TO END 1M times-----------");
        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd("kek", arrayBasedService.getSize());
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd("kek", linkedListBasedService.getSize());

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }


    @Test
    public void compareDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM BEGGING 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(0);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK ADD ELEMENT FROM MIDDLE 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(arrayBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM END 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(arrayBasedService.getSize() - 1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(arrayBasedService.getSize() - 1);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK DELETE ELEMENT FROM LIST 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList("kek");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList("kek");

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }




























}
