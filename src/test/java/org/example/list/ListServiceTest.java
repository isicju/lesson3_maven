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
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 500 TIMES-----------");
        for (int i = 0; i < 500; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheMiddle(linkedListBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 500f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 500f);
    }

    @Test
    public void compareGetElementFromTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE END 5M TIMES-----------");

        for (int i = 0; i < 5_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(linkedListBasedService.getSize()-1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5_000_000f);
    }

    @Test
    public void compareGetElementFromTheBeginning() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGINNING 5M TIMES-----------");

        for (int i = 0; i < 5_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBeginning(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBeginning(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5_000_000f);
    }
    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK CONTAINS ELEMENT 200 TIMES-----------");

        for (int i = 0; i < 200; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(Math.random()*(arrayBasedService.getSize()-1));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(Math.random()*(linkedListBasedService.getSize()-1));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 200f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 200f);
    }

    @Test
    public void compareAddElementFromBeggining() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT FROM THE BEGINNING 60K TIMES-----------");

        for (int i = 0; i < 60_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBeggining("element",0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBeggining("element",0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 60_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 60_000f);
    }

    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT TO THE MIDDLE 200 TIMES-----------");

        for (int i = 0; i < 200; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle("element",arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle("element",linkedListBasedService.getSize() / 2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 200f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 200f);
    }

    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADD ELEMENT TO THE END 5M TIMES-----------");

        for (int i = 0; i < 5_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd("element",arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd("element",linkedListBasedService.getSize()-1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5_000_000f);
    }

    @Test
    public void compareDeleteElementFromBeginning() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE BEGINNING 60K TIMES-----------");

        for (int i = 0; i < 60_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBeginning(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBeginning(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 60_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 60_000f);
    }

    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE MIDDLE 300 TIMES-----------");

        for (int i = 0; i < 300; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(linkedListBasedService.getSize() / 2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 300f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 300f);
    }

    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE END 900K TIMES-----------");

        for (int i = 0; i < 900_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(linkedListBasedService.getSize()-1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 900_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 900_000f);
    }

    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM LIST 900 TIMES-----------");

        for (int i = 0; i < 900; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle((int)(Math.random()*(arrayBasedService.getSize()-1)));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle((int)(Math.random()*(linkedListBasedService.getSize()-1)));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 900f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 900f);
    }

}
