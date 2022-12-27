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
        System.out.println();
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
        System.out.println();
    }

    @Test
    public void compareGetElementFroTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGINNING 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
        System.out.println();
    }

    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK THAT LIST CONTAINS ELEMENT 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement("some element");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement("some element");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
        System.out.println();
    }

    @Test
    public void compareAddElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT TO THE BEGINNING 50K times-----------");

        for (int i = 0; i < 50_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging("start element", 0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging("start element", 0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 50_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 50_000f);
        System.out.println();
    }

    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT TO THE MIDDLE 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle("mid element", arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle("mid element", arrayBasedService.getSize() / 2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
        System.out.println();
    }

    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT TO THE END 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd("end element", arrayBasedService.getSize());
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd("end element", arrayBasedService.getSize());
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
        System.out.println();
    }

    @Test
    public void compareDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE BEGINNING 100K times-----------");

        for (int i = 0; i < 100_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 100_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 100_000f);
        System.out.println();
    }

    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE MIDDLE 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(arrayBasedService.getSize() / 2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
        System.out.println();
    }

    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE END 500K times-----------");

        for (int i = 0; i < 500_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(arrayBasedService.getSize());
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(arrayBasedService.getSize());
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 500_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 500_000f);
        System.out.println();
    }

    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE LIST 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList("some element");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList("some element");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
        System.out.println();
    }

}
