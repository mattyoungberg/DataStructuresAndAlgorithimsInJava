package com.mattyoungberg.StacksAndQueues.Interfaces;

public interface IPriorityQueue {

    void insert(int item);

    int remove();

    int peek();

    boolean isEmpty();

    boolean isFull();
}
