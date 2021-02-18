package com.mattyoungberg.LinkedLists.Interfaces;

public interface IDoublyLinkedList {

    void insertFirst(int item);
    // Special case: the list is empty

    void insertLast(int item);
    // Special case: the list is empty

    void insertAfter(int item, int after);
    // Special case: `after` is the last link in the list.

    void deleteFirst();

    void deleteLast();

    void deleteKey(int key);
    // Special case: `current` is the first or last link.

    boolean isEmpty();

    int[] getList();
}
