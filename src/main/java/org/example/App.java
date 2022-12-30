package org.example;

import java.text.ParseException;

class App {
    
    String inputText = "{\"time\":\"2022-12-30 13:50\", \"label\":\"Office standup meeting\"}";
    boolean flagIsDone = false;
    
    public static void main(String[] args) throws ParseException, InterruptedException {
        App app = new App();
        app.flagIsDone = false;
        ParsingInputString parsingInputString = new ParsingInputString();
        parsingInputString.parsingJson();
    }


    // TaskScheduler -> periodically check some tasks


    public String helloWorld() {
        return "hello world";
    }
}
