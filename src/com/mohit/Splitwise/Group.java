package com.mohit.Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group {
    String id;
    String name;
    List<User> users;
    List<Expense> expenses;
    ExpenseController expenseController;
    public  Group(String id,String name,List<User> users) {
        this.name = name;
        this.id = id;
        this.users = users;
        this.expenses = new ArrayList<>();
    }

    public void populateExpense(Expense expense, Split split) {
        for(Map.Entry<User,Integer> entry : expense.owedMap.entrySet()) {
            User user = entry.getKey();
            int owed = entry.getValue();
            if(split.paidBy == user) continue;
            int alreadyOwed = split.paidBy.owe.getOrDefault(user,0);
            int newTotalOwed = alreadyOwed + owed;
            split.paidBy.owe.put(user,newTotalOwed);

        }
    }

    public  void addExpense(Split split) {
        expenseController = getExpenseController(split.strategy);
        Expense expense = expenseController.addExpense(split);
        expenses.add(expense);
        populateExpense(expense,split);
    }

    public ExpenseController getExpenseController(Strategy strategy) {
        return switch (strategy) {
            case EQUAL ->  new ExpenseController(new EqualSplit());
            case UNEQUAL -> new ExpenseController(new EqualSplit());
            case PERCENT -> new ExpenseController(new EqualSplit());
        };
    }


}

class GroupController {
    List<Group> groups;
    public GroupController() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void addExpense(Group group, Split split) {
        for(Group cur : groups) {
            if (cur.id == group.id) {
                cur.addExpense(split);
            }
        }
    }
}
