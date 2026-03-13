package com.mohit.multithreading2;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    Queue<Integer> queue = new LinkedList<>();
    Object lock = new Object();
    int max_queue_capaticy = 5;

    void produce(int i) throws InterruptedException {
        synchronized (lock) {
            while(queue.size() == max_queue_capaticy) {
                lock.wait();
            }

            queue.add(i);
            System.out.println("produce successful : " + i);
            lock.notifyAll();
        }
    }

    void consumer() throws InterruptedException {
        synchronized (lock) {
            while(queue.isEmpty()) {
                lock.wait();
            }
            int top = queue.poll();
            System.out.println("processing ...." + top);
            lock.notifyAll();
        }
    }

}

class ProducerConsumerRun{
    static void main() {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<20;i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2  = new Thread(() -> {
            for(int i =0;i<20;i++) {
                try {
                    producerConsumer.consumer();
                } catch (InterruptedException e) {

                }
            }
        });

        t1.start();
        t2.start();

        try {


            t1.join();
            t2.join();

        } catch (Exception e ) {

        }


    }
}


