package com.company.task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorBFS implements MyIterator {

    NodeI startNode;
    LinkedList<NodeI> queue;
    NodeI current;
    List<NodeI> resultList;


    IteratorBFS(Node startNode) {
        setStartNode(startNode);
    }

    public void setStartNode(NodeI startNode) {
        this.startNode = startNode;
        reset();
    }

    @Override
    public void reset() {
        queue = new LinkedList<NodeI>();
        current = startNode;
        queue.add(current);

    }

    @Override
    public NodeI getValue() {
        return current;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public NodeI next() {

        current = queue.poll();
        queue.addAll(current.getChildren());
        return current;
    }
}
