package com.company.task2.utils;

import java.util.ArrayList;

public class TasksRepo extends ArrayList<Task> {
    private TasksRepo() {
    }

    private static TasksRepo instance;

    public static TasksRepo getInstance() {
        if (instance == null) {
            instance = new TasksRepo();
        }
        return instance;
    }
}
