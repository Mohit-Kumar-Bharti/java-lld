package com.mohit.Splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
    static void main() {
        User user1 = new User(UUID.randomUUID().toString(),"ram");
        User user2 = new User(UUID.randomUUID().toString(),"shyam");
        User user3 = new User(UUID.randomUUID().toString(),"karan");

        GroupController groupController = new GroupController();
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Group group = new Group(UUID.randomUUID().toString(),"group goa", users);
        groupController.addGroup(group);

        Map<User,Integer> userOwe = new HashMap<>();
        userOwe.put(user2,100);
        userOwe.put(user3,100);
        Split split = new Split(200, Strategy.EQUAL, user1, userOwe);

        groupController.addExpense(group,split);

        user1.showData();
        user2.showData();
        user3.showData();

        groupController.addExpense(group,split);

        user1.showData();
        user2.showData();
        user3.showData();
    }
}
