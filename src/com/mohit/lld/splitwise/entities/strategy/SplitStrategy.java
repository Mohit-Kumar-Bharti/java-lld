package com.mohit.lld.splitwise.entities.strategy;

import com.mohit.lld.splitwise.entities.Split;
import com.mohit.lld.splitwise.entities.User;

import java.util.List;

public interface SplitStrategy {
    List<Split>  getSplits(double amount, List<User> users,   List<Double> splitAmounts);
}
