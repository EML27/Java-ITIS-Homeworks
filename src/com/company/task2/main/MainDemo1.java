package com.company.task2.main;

import com.company.task2.utils.Task;

import java.util.Scanner;

public class MainDemo1 {
    public static void main(String[] args) {
        Task task = new Task();
        TaskInterpreter ti = new TaskInterpreter();
        ti.currentTask = task;

        Scanner sc = new Scanner(System.in);
        String str = null;
        while (!str.equals("q")) {
            ti.execute(str);
            str = sc.nextLine();
        }
    }
}
