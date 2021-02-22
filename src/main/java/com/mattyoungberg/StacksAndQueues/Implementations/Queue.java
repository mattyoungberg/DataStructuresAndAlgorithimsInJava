package com.mattyoungberg.StacksAndQueues.Implementations;

import com.mattyoungberg.StacksAndQueues.Interfaces.IQueue;

public class Queue implements IQueue {

    private final int maxSize;
    private final int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    @Override
    public void insert(int item) {
        if (!isFull()) {
            if (rear == maxSize - 1)
                rear = -1;
            queueArray[++rear] = item;
            nItems++;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int remove() {
        if (!isEmpty()) {
            int temp = queueArray[front++];
            if (front == maxSize)
                front = 0;
            nItems--;
            return temp;
        } else
            return -1;
    }

    @Override
    public int peek() {
        if (!isEmpty())
            return queueArray[front];
        else
            return -1;
    }

    @Override
    public boolean isFull() {
       return nItems == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public int size() {
        return nItems;
    }
}
