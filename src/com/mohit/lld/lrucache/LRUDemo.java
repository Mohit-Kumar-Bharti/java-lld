package com.mohit.lld.lrucache;

public class LRUDemo {
    public static void main(String[] args) {
        LRUServ<String,String> lruServ = LRUServ.getInstance();

        lruServ.put("a","b");
        lruServ.put("c","d");

        String val =  lruServ.get("c");

        System.out.printf("val is %s for key %s", val, "c");
    }
}
