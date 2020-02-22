package com.company.task2.utils;

public class User {
    String name;
    int id;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = UsersRepo.getInstance().getLastId()+1;
        UsersRepo.getInstance().add(this);
        UsersRepo.getInstance().setLastId(id);
    }
}
