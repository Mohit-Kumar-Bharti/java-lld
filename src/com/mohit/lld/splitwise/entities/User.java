package com.mohit.lld.splitwise.entities;

import java.util.UUID;

public class User {
    String id;
    String name;
    BalanceSheet balanceSheet;

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.balanceSheet = new BalanceSheet(this);
    }

    public BalanceSheet getBalanceSheet () {
        return balanceSheet;
    }
    public String getName () {
        return name;
    }

}
