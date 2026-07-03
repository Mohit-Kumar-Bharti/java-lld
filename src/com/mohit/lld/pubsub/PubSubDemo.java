package com.mohit.lld.pubsub;

import com.mohit.lld.pubsub.message.Message;
import com.mohit.lld.pubsub.subscriber.NewsSubcriber;
import com.mohit.lld.pubsub.subscriber.Subscriber;

import java.util.UUID;

public class PubSubDemo {
    public static void main(String[] args) {
        PubsubSer pubsub = PubsubSer.getInstance();

        String topic = "sports";
        Subscriber subscriber1 = new NewsSubcriber();

        Subscriber subscriber2 = new NewsSubcriber();

        pubsub.addTopic(topic);
        pubsub.addSubscription(topic, subscriber1);
        pubsub.addSubscription(topic, subscriber2);


        pubsub.addMessage(topic, new Message(UUID.randomUUID().toString(), "herelooo "));

        pubsub.shutdown();

    }
}
