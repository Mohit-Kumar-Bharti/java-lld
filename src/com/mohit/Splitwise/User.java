package com.mohit.Splitwise;
import  java.util.*;

public class User {
    String id;
    String name;
    Map<User,Integer> owe;
    public  User(String id, String  name) {
        this.id = id;
        this.name = name;
        this.owe = new HashMap<>();
    }

    public  void showData() {
        for(Map.Entry<User,Integer> entry : owe.entrySet()) {
            System.out.println("here is " + entry.getKey().name + " owe .." + entry.getValue() + "... to " + name) ;
        }
    }
}
