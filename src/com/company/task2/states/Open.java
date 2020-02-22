package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class Open extends State {
    public Open(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().setCurrentState(new Assign(this.getContext()));
    }

    @Override
    public void down() {
        getContext().setCurrentState(new BackLog(this.getContext()));
    }

}
