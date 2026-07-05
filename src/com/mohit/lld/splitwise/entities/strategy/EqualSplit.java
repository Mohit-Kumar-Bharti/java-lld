package com.mohit.lld.splitwise.entities.strategy;

import com.mohit.lld.splitwise.entities.Split;
import com.mohit.lld.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy {

    @Override
    public List<Split> getSplits(double amount, List<User> users, List<Double> splitAmounts) {
        List<Split> splits = new ArrayList<>();
        int count = users.size();
        double amountperperson = amount/count;
        for(User user : users) {
            splits.add(new Split(user, amountperperson));
        }
        return splits;
    }
}
