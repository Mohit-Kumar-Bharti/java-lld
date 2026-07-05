package com.mohit.lld.splitwise.entities;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    User owner;

    Map<User, Double> balances;

    public BalanceSheet(User owner) {
        this.owner = owner;
        balances = new HashMap<>();
    }

    public synchronized  void addBalance (User user, double amount) {
        double oldBalance = balances.getOrDefault(user, 0.0);
        balances.put(user, oldBalance + amount);
    }

    public void showBalanceSheet() {
        System.out.println("Balance Sheet : " + this.owner.getName());
        for(Map.Entry<User, Double> entry : balances.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }


}
