package com.company.task1;

import java.util.ArrayList;
import java.util.List;

public interface NodeI {
    NodeI getParent();
    String getName();
    int getPriority();
    Type getType();
    List<NodeI> getChildren();

    void addChild(NodeI node);
    void setParent(NodeI parent);

    enum Type{
        COUNTRY(0),
        REGION(1),
        SUBREGION(2),
        CITY(3),
        STREET(4),
        HOUSE(5),

        ;
        int type;
        Type(int i){type = i;}

        Type getLower(){
            switch (this){
                case COUNTRY: return REGION;
                case REGION: return SUBREGION;
                case SUBREGION: return CITY;
                case CITY: return STREET;
                case STREET: return HOUSE;
                default: return COUNTRY;
            }
        }
    }
}
