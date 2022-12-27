package org.example.lists;

import java.util.List;

public class ListService<E> {

    private List<E> list;

    public ListService(List<E> list) {
        this.list = list;
    }

    public int getSize() {
        return list.size();
    }

    public long getElementFromTheMiddle(int index) {
        long before = System.currentTimeMillis();
        list.get(list.size() / 2);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheEnd(int index) {
        long before = System.currentTimeMillis();
        list.get(list.size() - 1);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheBegging(int index) {
        long before = System.currentTimeMillis();
        list.get(0);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long checkContainsElement(Object element) {
        long before = System.currentTimeMillis();
        list.contains(element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementFromBegging(E element) {
        long before = System.currentTimeMillis();
        list.add(0, element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheMiddle(E element) {
        long before = System.currentTimeMillis();
        list.add(list.size() / 2, element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheEnd(E element) {
        long before = System.currentTimeMillis();
        list.add(list.size(), element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromBegging(int index) {
        long before = System.currentTimeMillis();
        list.remove(0);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromMiddle(int index) {
        long before = System.currentTimeMillis();
        list.remove(list.size() / 2);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromEnd(int index) {
        long before = System.currentTimeMillis();
        list.remove(list.size() - 1);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromList(E element) {
        long before = System.currentTimeMillis();
        list.remove(element);
        long after = System.currentTimeMillis();
        return after - before;
    }


}
