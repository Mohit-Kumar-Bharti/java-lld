package com.mohit.multithreading2;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleThreadPool {
    Queue<Runnable> readyQueue = new LinkedList<>();
    Object lock = new Object();
    Thread[] workers;
    boolean isRunning = true;

    public  SimpleThreadPool(int threadCount) {
        workers = new Thread[threadCount];
        for(int i =0;i<threadCount;i++) {
            workers[i] = new Thread(this::workerLoop, "thread - " + i);
            workers[i].start();
        }
    }

    public void execute(Runnable job) {
        synchronized (lock) {
            readyQueue.add(job);
            lock.notifyAll();
        }
    }

    private void workerLoop() {
        Runnable job;
        while(true) {
            synchronized (lock) {
                while(readyQueue.isEmpty() && isRunning) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                //Exit condition
                if(!isRunning && readyQueue.isEmpty()) {
                    return;
                }

                job = readyQueue.poll();

            }

            try {
                job.run();
            } catch (Exception e) {
                System.out.println("error in job " + e.getMessage());
            }
        }
    }

    //shutdonw method;
    void shutdown() {
        synchronized (lock) {
            isRunning = false;
            lock.notifyAll();
        }
    }

    static void main() {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(3);
        for(int i = 0;i<10;i++) {
            int job = i;
            simpleThreadPool.execute(() -> {
                System.out.println("executing task " + job + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {};
            });
        };
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        simpleThreadPool.shutdown();
    }
}


