package com.company.task1;

import com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Interpreter {

    MyIterator iter;

    MyTree tree;

    Interpreter(Node start) {
        iter = new IteratorDFS(start);
        tree = new MyTree();
        tree.startNode = start;
    }

    Interpreter(MyTree tree) {
        iter = new IteratorDFS(tree.startNode);
        this.tree = tree;
    }

    void execute(String command) {
        String[] args = command.split(" ");
//        LinkedList<String> argsQueue = new LinkedList<>();
//        argsQueue.addAll(args);
        NodeI mem;
        try {
        switch (args[0]) {
            case "return": {
                switch (args[1]) {
                    case "children": {
                        mem = searchNodeWithName(args[2]);
                        for (NodeI x : mem.getChildren()) {
                            System.out.println(x.getName());
                        }
                        break;
                    }
                    default: {
                        System.out.println(searchNodeWithName(args[1]).getName());
                    }
                }
                break;
            }
            case "add": {
//                LinkedList<String> list = new LinkedList<>();
//                for (int i = 1; i < args.length; i++) {
//                    list.add(args[i]);
//                }
//                operationAdd(list);
                NodeI parent = searchNodeWithName(args[1]);
                parent.addChild(new Node(args[2],Integer.parseInt(args[3]),parent.getType().getLower()));
                break;
            }
            case "show": {
                tree.getAll(new IteratorDFS(tree.startNode));
                break;
            }
            case "delete":{
                NodeI nod = searchNodeWithName(args[1]);
                nod.getParent().getChildren().remove(nod);
                break;
            }
            case "save":{
                TreeSaverFacade ts = TreeSaverXML.getInstance();
                ts.writeTree(tree);
                break;
            }
            default:
                System.out.println("wrong command");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private NodeI searchNodeWithName(String name) {

        while (iter.hasNext()) {
            if (iter.next().getName().equals(name)) {
                NodeI res = iter.getValue();
                iter.reset();
                return res;
            }
        }
        iter.reset();
        throw new IllegalArgumentException();
    }

    /*private void operationAdd(LinkedList<String> address) {
        NodeI mem = searchNodeWithName(address.get(0));
        NodeI prev;
        for (String name : address) {
            prev = mem;
            for (NodeI child : mem.getChildren()) {
                if (child.getName().equals(name)) {
                    prev = mem;
                    mem = child;
                    address.poll();
                }
            }
            if (mem == prev) {
                break;
            }
        }
        address.poll();

        for (String name : address) {
            Node newNode = new Node(name, 0, mem.getType().getLower());
            mem.addChild(newNode);
            mem = newNode;
        }
    }*/

    private void operationAdd(LinkedList<String> args){

    }

//    NodeI findLastChild(LinkedList<String> list) {
//        NodeI node = searchNodeWithName(list.poll());
//        for (String name : list) {
//            for (NodeI curr : node.getChildren()) {
//                if (curr.getName().equals(name)){
//
//                }
//            }
//        }
//    }
}
