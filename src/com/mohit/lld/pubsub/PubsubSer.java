package com.mohit.lld.pubsub;

import com.mohit.lld.pubsub.message.Message;
import com.mohit.lld.pubsub.subscriber.Subscriber;
import com.mohit.lld.pubsub.topic.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PubsubSer {
    private static PubsubSer Instance;
    Map<String, Topic> topicRegistry;
    ExecutorService executor;

    public PubsubSer() {
        topicRegistry = new ConcurrentHashMap<>();
        executor = Executors.newFixedThreadPool(10);
    }


    public static PubsubSer getInstance() {
        if (Instance == null) {
            synchronized (PubsubSer.class) {
                Instance = new PubsubSer();
            }
        }
        return Instance;
    }

    public Topic addTopic(String topicName) {
        Topic topic = new Topic(UUID.randomUUID().toString(), topicName, executor);
        topicRegistry.put(topicName, topic);
        return topic;
    }

    public boolean addSubscription(String topicName, Subscriber subscriber) {
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) {
            return false;
        }
        topic.addSubscriber(subscriber);
        return true;
    }

    public void addMessage(String topicName, Message message) {
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) {
            return ;
        }
        topic.publish(message);
        return ;
    }

    public void shutdown() {
        System.out.println("Shutdown PubsubSer");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
            executor.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
