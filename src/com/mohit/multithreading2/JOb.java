package com.mohit.multithreading2;

public class JOb {
    String id;

    public JOb(String id) {
        this.id = id;
    }

    public void execute() {
        System.out.println("this job " + id + "is running ..");
    }
}
