package org.example.exceptions;

import java.util.*;

public class Errors {

    public void throwsOOOException(){
        List<String> list = new ArrayList<>();
        while (true){
            list.add("SuperString");
        }

    }
    public void throwsOOOExceptionWithArray(){
        String[][] array = new String[10000 * 100000][10000 * 100000];
    }

    public void throwsOOOExceptionWithHashMap(){
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }

    public void throwsStackOverFlowError(){
        throwsStackOverFlowError();
    }
}
