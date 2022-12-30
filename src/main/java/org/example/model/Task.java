package org.example.model;

import java.util.Date;

public class Task {
    String label;
    Date time;

    public Date getTime() {
        return time;
    }

    public Task(String label, Date time) {
        this.label = label;
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}