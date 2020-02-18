package com.company.task1;

public class MainTSDemo {
    public static void main(String[] args) {
        TreeSaverFacade ds= TreeSaverXML.getInstance();

        MyTree mt = new MyTree();
        mt.init();

        ds.writeTree(mt);

        MyTree mt2 = ds.readTree();
        mt2.getAll(new IteratorDFS());
    }
}
