package com.mattyoungberg.LinkedLists.Interfaces;

public interface ISortedList {

    void insert(int item);
    // Special cases: link inserted at the BEGINNING or at the END. pg 214

    void deleteFirst();

    boolean isEmpty();

    int[] getList();
}
