package com.mattyoungberg.StacksAndQueues.Implementations;

import com.mattyoungberg.StacksAndQueues.Interfaces.IPriorityQueue;

public class PriorityQueue implements IPriorityQueue {

    public int maxSize;
    public int[] queueArray;
    public int nItems;

    public PriorityQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.nItems = 0;
    }

    @Override
    public void insert(int item) {
        if (nItems == 0)
            queueArray[nItems++] = item;
        else if (isFull())
            throw new ArrayIndexOutOfBoundsException();
        else {
            int i;
            for(i = nItems - 1; i >= 0; i--) {
                if (item > queueArray[i])
                    queueArray[i+1] = queueArray[i];
                else
                    break;
            }
            queueArray[i+1] = item;
            nItems++;
        }
    }

    @Override
    public int remove() {
        if (!isEmpty())
            return queueArray[--nItems];
        else
            return -1;
    }

    @Override
    public int peek() {
        if (!isEmpty())
            return queueArray[nItems - 1];
        else
            return -1;
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }
}
