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

    public long getElementFroTheMiddle(int index) {
        long before = System.currentTimeMillis();
        list.get(index);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheEnd(int index) {
        long before = System.currentTimeMillis();
        list.get(index);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheBegging(int index) {
        long before = System.currentTimeMillis();
        list.get(index);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long checkContainsElement(Object element) {
        long before = System.currentTimeMillis();
        list.contains(element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToBegging(E element, int index) {
        long before = System.currentTimeMillis();
        list.add(index, element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheMiddle(E element, int index) {
        long before = System.currentTimeMillis();
        list.add(index, element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheEnd(E element,int index) {
        long before = System.currentTimeMillis();
        list.add(index, element);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromBegging(int index) {
        long before = System.currentTimeMillis();
        list.remove(index);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromMiddle(int index) {
        long before = System.currentTimeMillis();
        list.remove(index);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromEnd(int index) {
        long before = System.currentTimeMillis();
        list.remove(index);
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
