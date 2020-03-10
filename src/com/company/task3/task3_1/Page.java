package com.company.task3.task3_1;

import java.util.LinkedList;

public class Page {
    public String name;
    public LinkedList<String> listOfLinks = new LinkedList<>();

    public Page(String name, LinkedList<String> listOfLinks) {
        this.name = name;
        this.listOfLinks = listOfLinks;
    }

}
