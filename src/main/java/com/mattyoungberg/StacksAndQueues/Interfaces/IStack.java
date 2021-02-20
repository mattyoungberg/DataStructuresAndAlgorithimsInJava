package com.mattyoungberg.StacksAndQueues.Interfaces;

public interface IStack {

    void push(int item);

    int pop();

    int peek();

    boolean isEmpty();

    boolean isFull();
}
