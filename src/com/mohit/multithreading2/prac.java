package com.mohit.multithreading2;

import java.util.LinkedList;
import java.util.Queue;

class ProCon {
    Queue<Runnable> queue;
    Object lock;
    int capacity;
    Thread[] workers;

    public ProCon(int capacity) {
        queue = new LinkedList<>();
        lock = new Object();
        this.capacity = capacity;
        workers = new Thread[7];
        for(int i=0;i<3;i++) {
            workers[i] = new Thread(this::consume);
            workers[i].start();
        }
    }


    void produce(Runnable job) {
        synchronized (this.lock) {
            while(queue.size() == capacity) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
                }
                ;
            }

            queue.add(job);
            lock.notifyAll();
        }

    }

    void consume() {
        while (true) {

            Runnable job;
            synchronized (this.lock) {
                while (queue.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }

                }

                 job = queue.poll();
                lock.notifyAll();
            }
            job.run();

        }
    }
}
public class prac {
    static void main() throws InterruptedException {
        ProCon proCon = new ProCon(3);
        proCon.produce(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e){}
            System.out.println("JOb1");
        });
        proCon.produce(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e){}
            System.out.println("job2");
        });
        proCon.produce(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e){}
            System.out.println("job3");
        });
        System.out.printf("here 1 ");

        proCon.produce(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e){}
            System.out.println("job4");
        });

//        proCon.consume();

        Thread.sleep(5000);

    }
}
