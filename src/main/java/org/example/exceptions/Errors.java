package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Errors {

    public void throwsOOOException() {
        List<Object> objects = new ArrayList<>();
        while (true)
            objects.add(new Object());
    }

    public void throwsStackOverFlowError() {
        while (true)
           throwsStackOverFlowError();
    }
}
