package org.example.faang.online;

import java.util.HashSet;
import java.util.Set;

public class FindingLoopsInLinkedList {

    public static class MyNode {
        int value;
        public MyNode next;

        public MyNode(int value) {
            this.value = value;
        }
    }

    public static boolean hasLoopOnline(MyNode head) {
        Set<MyNode> previouslyUsed = new HashSet<>();
        MyNode currentNode = head;
        //N * (C0+C1) ~ N
        while (currentNode.next != null) {
            //C0
            if (previouslyUsed.contains(currentNode)) {
                return true;
            }
            //C1
            previouslyUsed.add(currentNode);
            currentNode = currentNode.next;
        }

        return false;
    }


}
