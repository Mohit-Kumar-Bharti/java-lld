package com.mohit.lld.splitwise.entities;

import java.util.List;
import java.util.UUID;

public class Group {
    String id;
    String name;
    List<User> users;

    public Group( String name, List<User> users) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }
    public String getName() {
        return name;
    }
}
