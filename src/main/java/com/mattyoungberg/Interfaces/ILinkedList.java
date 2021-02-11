package com.mattyoungberg.Interfaces;

public interface ILinkedList {

    Link first = null;

    class Link{}

    void insertFirst(int item);

    void deleteFirst();

    boolean search(int item);

    void delete(int item);

    boolean isEmpty();

    int[] getList();
}
