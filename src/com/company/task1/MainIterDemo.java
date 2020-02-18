package com.company.task1;

public class MainIterDemo {

    public static void main(String[] args) {
        MyTree mt = new MyTree();
        mt.init();

        MyIterator iter = new IteratorDFS(mt.startNode);

        while(iter.hasNext()){
            System.out.println(iter.next().getName());
        }
    }
}
