package com.company.task1;

import java.util.Iterator;
import java.util.List;

public class MyTree implements Iterable<Node> {
    Node startNode;

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public MyTree(){}

    void init(){
        startNode = new Node("Russia",0, NodeI.Type.COUNTRY);
        Node exNode1 = new Node("Tatarstan",0, NodeI.Type.REGION);
        Node exNode2 = new Node("Kazan",3, NodeI.Type.CITY);
        Node exNode3 = new Node("Elabuzhsky region",2, NodeI.Type.SUBREGION);
        Node exNode4 = new Node("Elabuga",1, NodeI.Type.CITY);
        Node exNode5 = new Node("Ulyanovsk oblast", 0, NodeI.Type.REGION);
        Node exNode6 = new Node("Ulyanovsk", 2, NodeI.Type.CITY);
        Node exNode7 = new Node("Baumana",3, NodeI.Type.STREET);
        Node exNode8 = new Node("Baumana 1", 0, NodeI.Type.HOUSE);
        Node exNode9 = new Node("Baumana 2", 0, NodeI.Type.HOUSE);
        Node exNode10 = new Node("Dimitrovgrad",0, NodeI.Type.CITY);

        startNode.addChild(exNode1);
        startNode.addChild(exNode5);
        exNode1.addChild(exNode2);
        exNode1.addChild(exNode3);
        exNode3.addChild(exNode4);
        exNode2.addChild(exNode7);
        exNode7.addChild(exNode8);
        exNode7.addChild(exNode9);
        exNode5.addChild(exNode6);
        exNode5.addChild(exNode10);
    }

    void getAll(MyIterator iterator){
        iterator.setStartNode(startNode);
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }

    @Override
    public Iterator<Node> iterator() {
        return null;
    }
}
