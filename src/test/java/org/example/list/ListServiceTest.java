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
        System.out.println("-----------GET ELEMENT FROM THE MIDDLE 10K times-----------");
        for (int i = 0; i < 10_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle(i);
            
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
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareGetElementFromTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GET ELEMENT FROM THE BEGGING 1M times-----------");
        
        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareCheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String item = "77";
        System.out.println("-----------CHECK CONTAINS ELEMENT  1K times-----------");
        
        for (int i = 0; i < 1_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(item);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(item);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareAddElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String item = "77";
        System.out.println("-----------COMPARE ADD ELEMENT FROM THE BEGGING 100K times-----------");
        
        for (int i = 0; i < 1_000_000; i++) {
            
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging(item, i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging(item, i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String item = "77";
        System.out.println("-----------COMPARE ADD ELEMENT FROM THE MIDDLE 1M times-----------");
        
        for (int i = 0; i < 1_000_000; i++) {
            
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle(item, i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle(item, i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String item = "77";
        System.out.println("-----------COMPARE ADD ELEMENT FROM THE END 1M times-----------");
        
        for (int i = 0; i < 1_000_000; i++) {
            
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd(item, i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd(item, i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE BEGGING 100K times-----------");
        
        for (int i = 0; i < 100_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE MIDDLE 10K times-----------");
        
        for (int i = 0; i < 10_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DELETE ELEMENT FROM THE END 1M times-----------");
        
        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(i);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(i);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
    
    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String item = "77";
        System.out.println("-----------DELETE ELEMENT FROM LIST  100K times-----------");
        
        for (int i = 0; i < 100_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList(item);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList(item);
        }
        
        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }
}
