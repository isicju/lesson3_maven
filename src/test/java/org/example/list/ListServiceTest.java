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
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 50K times-----------");
        for (int i = 0; i < 50000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheMiddle(arrayBasedService.getSize() / 2);
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
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(arrayBasedService.getSize()-1);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareGetElementFromTheBeginning() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGINNING 1M times-----------");
        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(0);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareRemoveElementFromTheBeginning() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE BEGINNING 50K times-----------");
        for (int i = 0; i < 50000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(0);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareRemoveElementFromTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE MIDDLE 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(arrayBasedService.getSize()/2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(linkedListBasedService.getSize()/2);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareRemoveElementFromTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE END 50K times-----------");
        for (int i = 0; i < 50000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(linkedListBasedService.getSize()-1);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareAddElementToTheBeginning() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------add ELEMENT To THE BEGINNING 50K times-----------");
        for (int i = 0; i < 50000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToBegging("gagag",0);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToBegging("gagag",0);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------add ELEMENT To THE MIDDLE 1K times-----------");
        for (int i = 0; i < 1000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToMiddle("gagag", arrayBasedService.getSize()/2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToMiddle("gagag", linkedListBasedService.getSize()/2);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------add ELEMENT To THE END 50K times-----------");
        for (int i = 0; i < 50000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToEnd("gaga",arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToEnd("gagag",linkedListBasedService.getSize()-1);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }



}
