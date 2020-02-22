package com.company.task2.utils;

public class TaskProxyImpl implements TaskProxyInt {

    TaskProxyImpl() {
        task = new Task();
    }

    Task task;


    @Override
    public void authorToNull() {
        task.authorToNull();
        System.out.println("Task with id " + task.getId() + ": author changed to null");
    }

    @Override
    public void testerToNull() {
        task.testerToNull();
        System.out.println("Task with id " + task.getId() + ": tester changed to null");
    }

    @Override
    public void problemToNull() {
        task.problemToNull();
        System.out.println("Task with id " + task.getId() + ": problem changed to null");
    }

    @Override
    public void up() {
        State prevState = task.getCurrentState();
        task.up();
        State newState = task.getCurrentState();

        System.out.println("Task with id " + task.getId() + ": action: up. Previous state: " + prevState.getClass().toString()
                + " Current state: " + newState.getClass().toString());
    }

    @Override
    public void down() {

        State prevState = task.getCurrentState();
        task.down();
        State newState = task.getCurrentState();

        System.out.println("Task with id " + task.getId() + ": action: down. Previous state: " + prevState.getClass().toString()
                + " Current state: " + newState.getClass().toString());
    }

    @Override
    public void up(int authorId) {

        State prevState = task.getCurrentState();
        task.up(authorId);
        State newState = task.getCurrentState();

        System.out.println("Task with id " + task.getId() + ": action: up. Previous state: " + prevState.getClass().toString()
                + " Current state: " + newState.getClass().toString());
        System.out.println("Author was set: id " + authorId);
    }

    @Override
    public void down(String errMsg) {

        State prevState = task.getCurrentState();
        task.down(errMsg);
        State newState = task.getCurrentState();

        System.out.println("Task with id " + task.getId() + ": action: down. Previous state: " + prevState.getClass().toString()
                + " Current state: " + newState.getClass().toString());
        System.out.println("Problem was set: message: " + errMsg);
    }

    @Override
    public Task copy() {
        System.out.println("Task with id " + task.getId() + " was copied");
        return task.copy();
    }
}
