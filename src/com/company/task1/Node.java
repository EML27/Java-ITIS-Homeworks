package com.company.task1;

import java.util.ArrayList;
import java.util.List;

public class Node implements NodeI {

    String name;
    int priority;
    Type myType;
    NodeI parent;
    List<NodeI> children;

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Type getMyType() {
        return myType;
    }

    public void setMyType(Type myType) {
        this.myType = myType;
    }

    public void setChildren(List<NodeI> children) {
        this.children = children;
    }


    public Node() {
    }

    @Override
    public NodeI getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public Type getType() {
        return myType;
    }

    @Override
    public List<NodeI> getChildren() {
        return children;
    }

    public Node(String name, int priority, Type myType) {
        this.name = name;
        this.priority = priority;
        this.myType = myType;
        children = new ArrayList<NodeI>();
    }

    public void setParent(NodeI parent) {
        this.parent = parent;
    }

    public void addChild(NodeI node) {
        children.add(node);
        node.setParent(node);
    }

    class Builder implements javafx.util.Builder {
        private Builder() {
        }

        public Builder setName(String name) {
            Node.this.name = name;
            return this;
        }

        public Builder setPriority(int i) {
            Node.this.priority = i;
            return this;
        }

        public Builder setType(Type type) {
            Node.this.myType = type;
            return this;
        }

        public Builder setParent(Node parent) {
            Node.this.parent = parent;
            return this;
        }

        public Builder setChildren(List<NodeI> children) {
            Node.this.children = children;
            return this;
        }

        @Override
        public Node build() {
            return Node.this;
        }
    }
}
