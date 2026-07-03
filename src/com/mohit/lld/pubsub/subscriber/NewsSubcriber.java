package com.mohit.lld.pubsub.subscriber;

import com.mohit.lld.pubsub.message.Message;

public class NewsSubcriber implements Subscriber {
    @Override
    public void onMessage(Message msg) {
        System.out.println(msg.getMessage());
    }
}
