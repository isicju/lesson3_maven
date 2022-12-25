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
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheMiddle(arrayBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5_000f);
    }

    @Test
    public void compareGetElementFromTheEnd() {
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

    @Test
    public void compareGetElementFromTheBegging() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Get Element From The Begging 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareCheckContainsElement() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Check Contains Element 1M times-----------");

        for (int i = 0; i < 12; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(1984);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(1984);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareAddElementFromBegging() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Add Element From Begging 15K times-----------");

        for (int i = 0; i < 15_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging("Random");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging("Random");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 15_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 15_000f);
    }

    @Test
    public void compareAddElementToTheMiddle() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Add Element To The Middle 5K times-----------");

        for (int i = 0; i < 5_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle("Random");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle("Random");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5_000f);
    }

    @Test
    public void compareAddElementToTheEnd() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Add Element To The End 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd("Random");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd("Random");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareDeleteElementFromBegging() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Delete Element From Begging 15K times-----------");

        for (int i = 0; i < 15_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 15_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 15_000f);
    }

    @Test
    public void compareDeleteElementFromMiddle() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Delete Element From Middle 1K times-----------");

        for (int i = 0; i < 1_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(0);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000f);
    }

    @Test
    public void compareDeleteElementFromEnd() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Delete Element From End 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareDeleteElementFromList() {

        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------Delete Element From List 1K times-----------");

        for (int i = 0; i < 1_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList("1984");
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList("1984");
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000f);
    }
}
