package org.example.lists;

import java.util.List;

public class ListService<T> {

    List<T> list;


    public ListService(List<T> list) {
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

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long getElementFromTheBegging(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long checkContainsElement(Object element) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementFromBegging(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheMiddle(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long addElementToTheEnd(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromBegging(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromMiddle(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }

    public long deleteElementFromEnd(int index) {
        long before = System.currentTimeMillis();

        // implementation

        long after = System.currentTimeMillis();
        return after - before;
    }


}
