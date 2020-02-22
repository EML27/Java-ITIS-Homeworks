package com.company.task2.utils;

import javafx.stage.Stage;

import java.lang.reflect.Constructor;

public abstract class State {
    private Task context;

    protected Task getContext() {
        return context;
    }

    public State(Task task) {
        this.context = task;
    }

    public abstract void up();

    public abstract void down();

    public <T extends State> T copy() {
        return copy(this.context);
    }

    public <T extends State> T copy(Task newContext) {
        T res = null;
        try {
            Constructor<? extends State> constructor = this.getClass().getConstructor(Task.class);
            res = (T) constructor.newInstance(newContext);
        } catch (Exception e) {
            System.out.println("Не, братан, че то не так");
        }
        return res;
    }
}
