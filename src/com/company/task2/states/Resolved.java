package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class Resolved extends State {

    public Resolved(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().problemToNull();
        getContext().setCurrentState(new InTest(this.getContext()));
    }

    @Override
    public void down() {

    }
}
