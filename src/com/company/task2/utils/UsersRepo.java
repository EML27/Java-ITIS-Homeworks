package com.company.task2.utils;

import java.util.ArrayList;

public class UsersRepo extends ArrayList<User> {
    static private UsersRepo instance;
    private int lastId = 0;

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    private UsersRepo() {
    }

    public static UsersRepo getInstance() {
        if (instance == null) {
            instance = new UsersRepo();
        }
        return instance;
    }
}
