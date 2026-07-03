package com.mohit.lld.pubsub.subscriber;

import com.mohit.lld.pubsub.message.Message;

public interface Subscriber {
    void onMessage(Message msg);
}
