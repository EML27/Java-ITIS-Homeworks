package com.company.task1;

import java.util.Scanner;

public class MainInterpreterDemo {


    public static void main(String[] args) {
        MyTree mt = new MyTree();
        mt.init();

        Interpreter inter = new Interpreter(mt);

        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("q")) {
                break;
            }
            inter.execute(str);

        }
    }
}
