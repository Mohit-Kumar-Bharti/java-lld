package com.mohit.lld.splitwise.entities;

import com.mohit.lld.splitwise.entities.strategy.SplitStrategy;

import java.util.List;

public class Expense {
    String id;
    User paidby;
    double amount;
    List<Split> splits;

    private Expense(ExpenseBuilder builder) {
        this.id = builder.id;
        this.paidby = builder.paidby;
        this.amount = builder.amount;
        this.splits = builder.splitStrategy.getSplits(builder.amount, builder.participants, builder.splitValues);
    }

    public User getPaidby() {
        return paidby;
    }
    public List<Split> getSplits() {
        return splits;
    }

    public static class ExpenseBuilder {
        String id;
        User paidby;
        double amount;
        SplitStrategy splitStrategy;
        List<User> participants;
        List<Double> splitValues;

        public ExpenseBuilder setId(String id) {this.id = id; return this;}
        public ExpenseBuilder setPaidby(User paidby) {this.paidby = paidby; return this;}
        public ExpenseBuilder setAmount(double amount) {this.amount = amount; return this;}
        public ExpenseBuilder setSplitStrategy(SplitStrategy splitStrategy) {this.splitStrategy = splitStrategy; return this;}
        public ExpenseBuilder setParticipants(List<User> participants) {this.participants = participants; return this;}
        public ExpenseBuilder setSplitValues(List<Double> splitValues) {this.splitValues = splitValues; return this;}

        public  Expense build() {
            if(splitStrategy == null) {
                throw  new IllegalArgumentException("SplitStrategy is null");
            }
            return new Expense(this);
        }


    }

}
