package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Errors {

    public void throwsOOOException() {
        List<Object> objects = new ArrayList<>();
            objects.add(new Object());
    }

    public void throwsStackOverFlowError() {
           throwsStackOverFlowError();
    }
}
