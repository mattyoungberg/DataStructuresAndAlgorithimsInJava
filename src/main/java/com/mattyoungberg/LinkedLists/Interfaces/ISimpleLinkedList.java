package com.mattyoungberg.LinkedLists.Interfaces;

public interface ISimpleLinkedList {

    void insertFirst(int item);

    void deleteFirst();
    // Special case: The list is empty. Pg. 188

    boolean search(int item);

    void delete(int item);
    // Special case: The current link is the first link. Pg. 196

    boolean isEmpty();

    int[] getList();
}
