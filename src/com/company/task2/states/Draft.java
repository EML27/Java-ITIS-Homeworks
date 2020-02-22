package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class Draft extends State {
    public Draft(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().setCurrentState(new Open(this.getContext()));
    }

    @Override
    public void down() {

    }
}
