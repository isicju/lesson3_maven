package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainTest extends DefaultTest{

    private App app;

    @BeforeAll
    public void init(){
        app = new App();
    }

    @Test
    public void testHelloWorld(){
        System.out.println(" test is running! ");
        app = new App();
        assertEquals("hello world", app.helloWorld());
    }

    

}
