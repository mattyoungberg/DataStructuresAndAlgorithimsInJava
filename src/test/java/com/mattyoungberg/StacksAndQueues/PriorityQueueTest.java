package com.mattyoungberg.StacksAndQueues;

import com.mattyoungberg.StacksAndQueues.Implementations.PriorityQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void insert_inOrder_remove() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        assertEquals(1, priorityQueue.remove());
        assertEquals(2, priorityQueue.remove());
        assertEquals(3, priorityQueue.remove());
    }

    @Test
    public void insert_inReverse_remove() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(3);
        priorityQueue.insert(2);
        priorityQueue.insert(1);
        assertEquals(1, priorityQueue.remove());
        assertEquals(2, priorityQueue.remove());
        assertEquals(3, priorityQueue.remove());
    }

    @Test
    public void insert_randomly_remove() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        priorityQueue.insert(1);
        assertEquals(1, priorityQueue.remove());
        assertEquals(2, priorityQueue.remove());
        assertEquals(3, priorityQueue.remove());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insert_overflow() {
        PriorityQueue priorityQueue = new PriorityQueue(1);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
    }

    @Test
    public void remove_empty() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        assertEquals(-1, priorityQueue.remove());
    }

    @Test
    public void peek() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        priorityQueue.insert(1);
        assertEquals(1, priorityQueue.peek());
        priorityQueue.remove();
        assertEquals(2, priorityQueue.peek());
        priorityQueue.remove();
        assertEquals(3, priorityQueue.peek());
    }

    @Test
    public void peek_empty() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        assertEquals(-1, priorityQueue.peek());
    }

    @Test
    public void isEmpty_full() {
        PriorityQueue priorityQueue = new PriorityQueue(1);
        priorityQueue.insert(1);
        assertFalse(priorityQueue.isEmpty());
    }

    @Test
    public void isEmpty_empty() {
        PriorityQueue priorityQueue = new PriorityQueue(1);
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void isFull_full() {
        PriorityQueue priorityQueue = new PriorityQueue(1);
        priorityQueue.insert(1);
        assertTrue(priorityQueue.isFull());
    }

    @Test
    public void isFull_empty() {
        PriorityQueue priorityQueue = new PriorityQueue(1);
        assertFalse(priorityQueue.isFull());
    }
}
