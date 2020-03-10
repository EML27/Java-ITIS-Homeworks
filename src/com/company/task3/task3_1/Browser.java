package com.company.task3.task3_1;

import java.util.LinkedList;

public class Browser {
    private Page currentPage = PagesRepo.INSTANCE.getPageByName("home");
    private LinkedList<Memento> backStack = new LinkedList<>();
    private LinkedList<Memento> forwardStack = new LinkedList<>();

    public void link(String name) {
        if (currentPage.listOfLinks.contains(name)) {
            backStack.add(new Memento());
            forwardStack = new LinkedList<>();
            setCurrentPage(PagesRepo.INSTANCE.getPageByName(name));
        }
    }

    public void goTo(String name) {
        backStack.add(new Memento());
        forwardStack = new LinkedList<>();
        setCurrentPage(PagesRepo.INSTANCE.getPageByName(name));
    }

    public void back() {
        if (backStack.isEmpty()) {
            System.out.println("back stack is empty");
            return;
        }
        forwardStack.add(new Memento());
        backStack.pop().rollback();
    }

    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("froward stack is empty");
            return;
        }
        backStack.add(new Memento());
        forwardStack.pop().rollback();
    }

    private void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
        System.out.println("current page is " + currentPage.name);
    }

    private class Memento {
        String pageName;

        public Memento() {
            pageName = currentPage.name;
        }

        public void rollback() {
            setCurrentPage(PagesRepo.INSTANCE.getPageByName(pageName));
        }
    }
}
