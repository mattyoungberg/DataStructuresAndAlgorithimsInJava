package com.mattyoungberg.LinkedLists.Interfaces;

public interface IDoubleEndedList {

    void insertFirst(int item);
    // Special case: list is empty.

    void insertLast(int item);
    // Special case: list is empty.

    void deleteFirst();

    boolean search(int item);

    int[] getList();
}
