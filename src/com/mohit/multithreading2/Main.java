package com.mohit.multithreading2;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static void main() throws InterruptedException {
        AtomicBoolean tem = new AtomicBoolean(true);
        Thread t1 = new Thread(() -> {
            while(tem.get()) {
                System.out.println("this is it>..");
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tem.set(false);
        });

        t1.start();
        t2.start();

        System.out.println("main done");
        t1.join();
    }
}
