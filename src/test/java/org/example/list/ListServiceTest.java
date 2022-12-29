package org.example.list;

import org.example.DefaultTest;
import org.example.lists.ListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 10K times-----------");
        for (int i = 0; i < 10000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle();

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 10000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 10000f);
    }

    @Test
    public void compareGetElementFroTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE END 150K times-----------");

        for (int i = 0; i < 150000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 150000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 150000f);
    }

    @Test
    public void compareGetElementFroTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GETTING 150000K ITEMS FROM THE START-----------");

        for (int i = 0; i < 150000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 150000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 150000f);
    }

    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------CHECK CONTAINS 5K ELEMENTS-----------");

        for (int i = 0; i < 5000; i++) {
            int element = 2533;
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(element);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(element);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareAddElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADDING 15K ELEMENTS TO THE BEGINNING-----------");

        for (int i = 0; i < 15000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 15000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 15000f);
    }

    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADDING 20K ELEMENTS TO THE MIDDLE-----------");

        for (int i = 0; i < 20000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 20000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 20000f);
    }

    @Test
    public void compareAddElementFromTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------ADDING 15K ELEMENTS TO THE END-----------");

        for (int i = 0; i < 15000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd(String.valueOf(i));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd(String.valueOf(i));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 15000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 15000f);
    }

    @Test
    public void compareDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE 35K ELEMENTS FROM THE BEGINNING-----------");

        for (int i = 0; i < 35000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 35000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 35000f);
    }


    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE 20K ELEMENTS FROM THE MIDDLE-----------");

        for (int i = 0; i < 20000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 20000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 20000f);
    }

    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE 20K ELEMENTS FROM THE END-----------");

        for (int i = 0; i < 20000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd();
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd();
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 20000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 20000f);
    }


    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE 20K ELEMENTS FROM LIST-----------");

        for (int i = 0; i < 20000; i++) {
            arrayBasedService.addElementToTheEnd(String.valueOf(i));
            linkedListBasedService.addElementFromBegging(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            int elementArray = new Random().nextInt(arrayBasedService.getSize() - 1);
            int elementList = new Random().nextInt(arrayBasedService.getSize() - 1);
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList(String.valueOf(elementArray));
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList(String.valueOf(elementList));
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 20000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 20000f);
    }


}
