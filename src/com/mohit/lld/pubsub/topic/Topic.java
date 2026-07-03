package com.mohit.lld.pubsub.topic;

import com.mohit.lld.pubsub.message.Message;
import com.mohit.lld.pubsub.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Topic {
    String id;
    String name;
    List<Subscriber> subscribers;
    ExecutorService executor;

    public Topic(String id, String name, ExecutorService executor) {
        this.id = id;
        this.name = name;
        subscribers = new ArrayList<>();
        this.executor = executor;
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void publish(Message msg) {
        for (Subscriber subscriber : subscribers) {
            executor.submit(() -> subscriber.onMessage(msg));
        }
    }
}
