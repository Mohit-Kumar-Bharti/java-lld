package com.mohit.concurrency;

public class prog1 {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("child thread threadName="+threadName);

            System.out.println("hello world");
        });
        thread.start();

        System.out.println("main thread is : " +  Thread.currentThread().getName());
    }
}
