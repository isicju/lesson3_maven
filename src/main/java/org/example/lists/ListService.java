package org.example.lists;

import java.util.List;

public class ListService<E> {
    static final int HALF_LIST = 2;
    static final int END_LIST = -1;
    static final int BEGGING_LIST = 0;
    private List<E> list;
    
    public ListService(List<E> list) {
        this.list = list;
    }
    
    public int getSize() {
        return list.size();
    }
    
    public void setList(List<E> list) {
        this.list = list;
    }
    
    public long getElementFroTheMiddle(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.get((list.size() / HALF_LIST) + index);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long getElementFromTheEnd(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.get(list.size() - 1);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long getElementFromTheBegging(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.get(BEGGING_LIST);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long checkContainsElement(Object element) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.contains(element);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long addElementFromBegging(E element, int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.add(BEGGING_LIST, element);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long addElementToTheMiddle(E element, int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.add( list.size() / HALF_LIST, element);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long addElementToTheEnd(E element, int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.add((list.size()), element);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long deleteElementFromBegging(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.remove(BEGGING_LIST);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long deleteElementFromMiddle(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.remove(list.size() / HALF_LIST) ;
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long deleteElementFromEnd(int index) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.get(list.size() -1);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    public long deleteElementFromList(E element) {
        long before = System.currentTimeMillis();
        
        // implementation
        list.remove(element);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    
}
