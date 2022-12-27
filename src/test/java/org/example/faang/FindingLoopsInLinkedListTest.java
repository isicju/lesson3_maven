package org.example.faang;

import org.example.DefaultTest;
import org.example.faang.online.FindingLoopsInLinkedList;
import org.junit.jupiter.api.Test;

import static org.example.faang.online.FindingLoopsInLinkedList.hasLoopOnline;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindingLoopsInLinkedListTest extends DefaultTest {


    @Test
    public void hasLoopTest(){
        FindingLoopsInLinkedList.MyNode head = new FindingLoopsInLinkedList.MyNode(12);
        FindingLoopsInLinkedList.MyNode secondNode = new FindingLoopsInLinkedList.MyNode(33);
        FindingLoopsInLinkedList.MyNode thirdNode = new FindingLoopsInLinkedList.MyNode(22);
        FindingLoopsInLinkedList.MyNode fourtNode = new FindingLoopsInLinkedList.MyNode(11);
        FindingLoopsInLinkedList.MyNode fifthsNode = new FindingLoopsInLinkedList.MyNode(55);
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourtNode;
        fourtNode.next = fifthsNode;

        assertFalse(hasLoopOnline(head));
    }

    @Test
    public void hasLoopTestPositive(){
        FindingLoopsInLinkedList.MyNode head = new FindingLoopsInLinkedList.MyNode(12);
        FindingLoopsInLinkedList.MyNode secondNode = new FindingLoopsInLinkedList.MyNode(33);
        FindingLoopsInLinkedList.MyNode thirdNode = new FindingLoopsInLinkedList.MyNode(22);
        FindingLoopsInLinkedList.MyNode fourtNode = new FindingLoopsInLinkedList.MyNode(11);
        FindingLoopsInLinkedList.MyNode fifthsNode = thirdNode;
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourtNode;
        fourtNode.next = fifthsNode;

        assertTrue(hasLoopOnline(head));
    }

}
