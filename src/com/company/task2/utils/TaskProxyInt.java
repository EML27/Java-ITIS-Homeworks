package com.company.task2.utils;

public interface TaskProxyInt {
    void authorToNull();

    void testerToNull();

    void problemToNull();

    void up();
    void down();

    void up(int authorId);
    void down(String errMsg);

    Task copy();
}
