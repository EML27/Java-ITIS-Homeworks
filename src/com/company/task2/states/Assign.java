package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class Assign extends State {
    public Assign(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().setCurrentState(new InProgress(this.getContext()));
    }

    @Override
    public void down() {
        getContext().authorToNull();
        getContext().setCurrentState(new Open(this.getContext()));
    }
}
