package org.example;

import java.lang.*;
import java.text.ParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;

class ParsingInputString {
    public String timeData;
    public String message;
    
    public void parsingJson() throws JsonSyntaxException, ParseException, InterruptedException {
        try {
            App app = new App();
            String jsonString = app.inputText;
            Gson gson = new Gson();
            DataAndMessage dataAndMessage = gson.fromJson(jsonString, DataAndMessage.class);
            timeData = dataAndMessage.getTime();
            message = dataAndMessage.getLable();
        } catch (JsonSyntaxException e) {
            System.out.println("ERROR - Invalid data entry format ");
        } catch (NullPointerException e) {
            System.out.println("ERROR - Empty line ");
        }
        SendingDateCalc dateCal = new SendingDateCalc();
        dateCal.remainingTimeCalculation(timeData, message);
    }
}

class DataAndMessage {
    String time;
    String label;
    
    public String getTime() {
        return time;
    }
    
    public String getLable() {
        return label;
    }
}
