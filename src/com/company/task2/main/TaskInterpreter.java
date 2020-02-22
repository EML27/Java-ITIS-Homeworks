package com.company.task2.main;

import com.company.task2.utils.Task;

public class TaskInterpreter {
    public Task currentTask;

    void execute(String command) {
        String[] args = command.split(" ");
        try {


        switch (args[0]) {
            case "up": {
                if (args.length == 1) {
                    currentTask.up();
                } else {
                    currentTask.up(Integer.parseInt(args[1]));
                }


                break;
            }
            case "down": {

                if (args.length == 1) {
                    currentTask.down();
                } else {
                    currentTask.down(args[1]);
                }
                break;
            }
//            case "new": {
//                switch (args[1]) {
//                    case "Task": {
//                        currentTask = new Task();
//                        break;
//                    }
//                    case "User": {
//
//                        break;
//                    }
//                }
//                break;
//            }
            default:
                System.out.println("unknown command");
        }}catch (Exception e){
            System.out.println("Error somewhere");
        }
    }
}
