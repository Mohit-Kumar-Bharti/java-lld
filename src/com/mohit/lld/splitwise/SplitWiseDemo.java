package com.mohit.lld.splitwise;

import com.mohit.lld.splitwise.entities.Expense;
import com.mohit.lld.splitwise.entities.Group;
import com.mohit.lld.splitwise.entities.User;
import com.mohit.lld.splitwise.entities.strategy.EqualSplit;

import java.util.List;
import java.util.UUID;

public class SplitWiseDemo {
    public static void main(String[] args) {
        SplitwiseSer splitwiseSer  = SplitwiseSer.getInstance();

        User user1 = splitwiseSer.addUser("mohit");
        User user2 = splitwiseSer.addUser("ram");
        User user3 = splitwiseSer.addUser("shyam");

        Group group1 = splitwiseSer.addGroup("trio", List.of(user1, user2, user3));

        Expense.ExpenseBuilder expenseBuilder = new Expense.ExpenseBuilder()
                .setId(UUID.randomUUID().toString())
                .setAmount(33)
                .setPaidby(user1)
                .setParticipants(List.of(user1, user2, user3))
                .setSplitStrategy(new EqualSplit())
                .setSplitValues(List.of());

        splitwiseSer.addExpense(expenseBuilder);

        splitwiseSer.showGroupBalance(group1.getName());
    }
}
