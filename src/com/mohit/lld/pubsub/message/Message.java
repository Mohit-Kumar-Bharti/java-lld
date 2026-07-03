package com.mohit.lld.pubsub.message;

public class Message {
     String id;
     String msg;

     public Message(String id, String msg) {
         this.id = id;
         this.msg = msg;
     }

     public String getMessage() {
         return msg;
     }
}
