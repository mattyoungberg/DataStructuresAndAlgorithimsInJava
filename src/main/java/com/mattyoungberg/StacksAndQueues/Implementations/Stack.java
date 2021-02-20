package com.mattyoungberg.StacksAndQueues.Implementations;

import com.mattyoungberg.StacksAndQueues.Interfaces.IStack;

public class Stack implements IStack {

    private final int maxSize;
    private final int[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    @Override
    public void push(int item) {
        if (!isFull())
            stackArray[++top] = item;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int pop() {
        if (!isEmpty())
            return stackArray[top--];
        else
            return -1;
    }

    @Override
    public int peek() {
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }
}
