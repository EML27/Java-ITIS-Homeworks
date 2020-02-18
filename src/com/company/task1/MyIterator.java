package com.company.task1;

import java.util.Iterator;

public interface MyIterator extends Iterator<NodeI> {
    void reset();
    NodeI getValue();
    void setStartNode(NodeI startNode);
}
