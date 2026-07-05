package com.mohit.lld.splitwise;

import com.mohit.lld.splitwise.entities.Expense;
import com.mohit.lld.splitwise.entities.Group;
import com.mohit.lld.splitwise.entities.Split;
import com.mohit.lld.splitwise.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseSer {
    private static SplitwiseSer instance;
    Map<String, Group> groupRegistry;
    Map<String , User> userRegistry;


    private SplitwiseSer() {
        groupRegistry = new HashMap<>();
        userRegistry = new HashMap<>();
    }

    public static synchronized SplitwiseSer getInstance() {
        if (instance == null) {
            instance = new SplitwiseSer();
        }
        return instance;
    }

    public User addUser(String userName) {
        User user = new User(userName);
        userRegistry.put(userName, user);
        return user;
    }

    public Group addGroup(String groupName, List<User> users) {
        Group group = new Group(groupName, users);
        groupRegistry.put(groupName, group);
        return group;

    }

    public synchronized void  addExpense(Expense.ExpenseBuilder expenseBuilder) {
        Expense expense = expenseBuilder.build();
        User paidBy = expense.getPaidby();

        List<Split>  splits = expense.getSplits();

        for (Split split : splits) {
            User participant = split.getUser();
            double amount = split.getAmount();

            if(!paidBy.equals(participant)) {
                participant.getBalanceSheet().addBalance(paidBy, -amount);
                paidBy.getBalanceSheet().addBalance(participant, amount);
            }
        }
    }

    public void showGroupBalance(String groupName) {
        Group group = groupRegistry.get(groupName);
        if(group == null) {
            return;
        }
        for(User user : group.getUsers()) {
            showUserBalance(user.getName());
        }
    }

    public void showUserBalance(String userName) {
        User user = userRegistry.get(userName);
        if(user == null) {
            return;
        }
        user.getBalanceSheet().showBalanceSheet();
    }







}