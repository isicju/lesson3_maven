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
        list.get(list.size() / 2);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheEnd() {
        long before = System.currentTimeMillis();
        list.get(list.size() - 1);

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheBegging() {
        long before = System.currentTimeMillis();
        list.get(0);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long checkContainsElement(Object element) {
        long before = System.currentTimeMillis();
        list.contains(element);

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementFromBegging(E element) {
        long before = System.currentTimeMillis();
        list.add(0, element);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheMiddle(E element) {
        long before = System.currentTimeMillis();
        list.add(list.size() / 2, element);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheEnd(E element) {
        long before = System.currentTimeMillis();
        list.add(list.size() - 1, element);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromBegging() {
        long before = System.currentTimeMillis();
        list.remove(0);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromMiddle() {
        long before = System.currentTimeMillis();
        list.remove(list.size() / 2);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromEnd() {
        long before = System.currentTimeMillis();
        list.remove(list.size() - 1);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromList(E element) {
        long before = System.currentTimeMillis();
        list.remove(element);
        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }


}
