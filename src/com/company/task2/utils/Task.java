package com.company.task2.utils;

import com.company.task2.states.Draft;
import com.company.task2.states.InTest;
import com.company.task2.states.Open;

public class Task {

    public Task() {
        TasksRepo.getInstance().add(this);
        setCurrentState(new Draft(this));
    }

    private Integer lastTesterId;
    private Integer lastAuthorId;
    private String problem;

    public void authorToNull() {
        lastAuthorId = null;
    }

    public void problemToNull() {
        problem = null;
    }

    public void testerToNull() {
        lastTesterId = null;
    }

    public int getId() {
        return TasksRepo.getInstance().indexOf(this);
    }

    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void down() {
        currentState.down();
    }

    public void down(String errMsg) {
        if (currentState.getClass().equals(InTest.class)) {
            down();
            problem = errMsg;
        }
    }

    public void up() {
        currentState.up();
    }

    public void up(int authorID) {
        if (currentState.getClass().equals(Open.class)) {
            up();
            lastAuthorId = authorID;
        } else throw new IllegalArgumentException();
    }

    private void donumMortis() {
        TasksRepo.getInstance().remove(this);
    }


    public Task copy() {
        Task res = new Task();
        res.problem = this.problem;
        res.lastTesterId = this.lastTesterId;
        res.lastAuthorId = this.lastAuthorId;
        res.currentState = this.currentState.copy(res);
        return res;
    }
}
