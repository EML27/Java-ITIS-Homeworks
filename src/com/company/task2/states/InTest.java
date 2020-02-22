package com.company.task2.states;

import com.company.task2.utils.State;
import com.company.task2.utils.Task;

public class InTest extends State {
    public InTest(Task task) {
        super(task);
    }

    @Override
    public void up() {
        getContext().problemToNull();
        getContext().testerToNull();
        getContext().setCurrentState(new Closed(this.getContext()));

    }

    @Override
    public void down() {
        getContext().setCurrentState(new Assign(this.getContext()));
    }
}
