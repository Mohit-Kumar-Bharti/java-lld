package com.mohit.multithreading2;


// Semaphor is also synconizeing mechanism with counter

// binary semaphore is counter 1 , only 1 thread can access it
// counting semaphore is counter > 1, so n threads can access critical section at a time
// acquire() and release() function
public class SemaphoreExample {
    static void main() {
        System.out.println("...");
        test t  = new test();
        t.check();
    }
}
class test{
    Object lock = new Object();

    void check() {
        synchronized (lock) {
            System.out.println("here in outer block ");
            synchronized (lock) {
                System.out.println("again inner block");
            }
        }
    }
}
