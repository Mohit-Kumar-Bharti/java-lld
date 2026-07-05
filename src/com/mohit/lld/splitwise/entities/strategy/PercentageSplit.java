package com.mohit.lld.splitwise.entities.strategy;

import com.mohit.lld.splitwise.entities.Split;
import com.mohit.lld.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplit implements SplitStrategy {
    @Override
    public List<Split> getSplits(double amount, List<User> users, List<Double> splitAmounts) {
        if(users.size()!=splitAmounts.size()) {
            throw new IllegalArgumentException("no of participants should be equal to splitAmounts");
        }

        if( Math.abs(splitAmounts.stream().mapToDouble(Double::doubleValue).sum()-100.00) > 0.01) {
            throw new IllegalArgumentException("splitAmounts should be equal to 100 %");
        }

        List<Split> splits = new ArrayList<>();
        for(int i=0;i<users.size();i++) {
            double amountForUser = amount * splitAmounts.get(i);
            splits.add(new Split(users.get(i),amountForUser));
        }
        return splits;
    }
}
