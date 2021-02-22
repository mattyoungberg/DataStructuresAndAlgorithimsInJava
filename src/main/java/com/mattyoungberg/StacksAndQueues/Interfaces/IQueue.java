package com.mattyoungberg.StacksAndQueues.Interfaces;

public interface IQueue {

    void insert(int item);

    int remove();

    int peek();

    boolean isFull();

    boolean isEmpty();

    int size();
}
