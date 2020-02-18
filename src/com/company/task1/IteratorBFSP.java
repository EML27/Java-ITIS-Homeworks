package com.company.task1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class IteratorBFSP implements MyIterator {
    NodeI startNode;
    LinkedList<NodeI> queue;
    NodeI current;


    IteratorBFSP(Node startNode) {
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
        LinkedList<NodeI> level = new LinkedList<>();
        level.addAll(current.getChildren());
        level.sort(Comparator.comparingInt(NodeI::getPriority));
        queue.addAll(level);
        return current;
    }
}
