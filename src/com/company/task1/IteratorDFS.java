package com.company.task1;

import java.util.LinkedList;

public class IteratorDFS implements MyIterator {

    LinkedList<NodeI> queue;
    NodeI startNode;
    NodeI current;

    IteratorDFS(Node startNode) {
        setStartNode(startNode);
    }
    IteratorDFS(){}

    public void setStartNode(NodeI startNode) {

        this.startNode = startNode;
        reset();
    }

    @Override
    public void reset() {
        queue = new LinkedList<>();
        fillQueue(startNode);
    }

    @Override
    public NodeI getValue() {
        return current;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void fillQueue(NodeI node) {
        queue.add(node);
        if (node.getChildren().isEmpty()) {
            return;
        }
        for (NodeI x : node.getChildren()) {
            fillQueue(x);
        }
    }

    @Override
    public NodeI next() {
        current = queue.poll();
        return current;
    }
}
