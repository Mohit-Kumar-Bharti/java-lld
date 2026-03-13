package com.mohit.Splitwise;
import  java.util.*;
public class Expense {
    String id;
    Map<User,Integer> owedMap;

    public Expense(String id,Map<User,Integer> owedMap) {
        this.id = id;
        this.owedMap = owedMap;
    }
}

class ExpenseController{
    SplitStrategy splitStrategy;

    public ExpenseController(SplitStrategy splitStrategy) {
        this.splitStrategy =splitStrategy;
    }

    public Expense addExpense(Split split) {
        Map<User,Integer> oweResult = splitStrategy.split(split);
        return  new Expense(UUID.randomUUID().toString(),oweResult);
    }
}
