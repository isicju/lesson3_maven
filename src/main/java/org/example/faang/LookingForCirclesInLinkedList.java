package org.example.faang;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LookingForCirclesInLinkedList {

    /* Link list Node */
    static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }

        Node next;
    }

    public static boolean hasCycle(Node head) {
        Set<Node> previousNodes = new HashSet<>();
        while (head != null) {
            if (previousNodes.contains(head)) {
                return true;
            } else {
                previousNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String args[])
    {
        Node sameNode = new Node(3);
        /* Start with the empty list */
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = sameNode;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print(hasCycle(head) ? "Yes\n"
                : "No\n");

        head.next.next.next.next.next = sameNode;
        System.out.print(hasCycle(head) ? "Yes\n"
                : "No\n");
    }

}
