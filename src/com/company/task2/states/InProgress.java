package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class InProgress extends State {
    public InProgress(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().setCurrentState(new Resolved(this.getContext()));
    }

    @Override
    public void down() {

    }
}
