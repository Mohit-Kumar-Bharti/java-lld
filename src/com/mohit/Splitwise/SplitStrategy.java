package com.mohit.Splitwise;
import java.util.*;

enum Strategy {
    EQUAL,
    UNEQUAL,
    PERCENT;
}

class Split{
    int totalAmount;
    Strategy strategy;
    User paidBy;
    Map<User,Integer> userOweMap;
    public Split(int totalAmount,Strategy strategy, User paidBy,Map <User,Integer> userOweMap) {
        this.totalAmount = totalAmount;
        this.strategy = strategy;
        this.paidBy = paidBy;
        this.userOweMap = userOweMap;
    }
}
public interface SplitStrategy {
    Map<User,Integer> split(Split split);
}

class EqualSplit implements SplitStrategy {
    @Override
    public Map<User,Integer> split(Split split) {
        Map<User,Integer> userOweBalance = new HashMap<>();
        int totalUsers = split.userOweMap.size();
        if(totalUsers == 0) {
            return userOweBalance;
        }
        int balancePerUser = split.totalAmount/totalUsers;
        for(Map.Entry<User,Integer> entry : split.userOweMap.entrySet()) {
            User user = entry.getKey();
            userOweBalance.put(user, Integer.valueOf(balancePerUser));
        }
        return  userOweBalance;
    }
}
