package com.mattyoungberg.StacksAndQueues;

import com.mattyoungberg.StacksAndQueues.Implementations.Queue;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void insert_remove() {
        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
    }

    @Test
    public void insert_remove_wrapAround() {
        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.remove();
        queue.insert(4);
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
        assertEquals(4, queue.remove());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insert_full() {
        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
    }

    @Test
    public void remove_empty() {
        Queue queue = new Queue(1);
        assertEquals(-1, queue.remove());
    }

    @Test
    public void peek() {
        Queue queue = new Queue(1);
        queue.insert(1);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(-1, queue.peek());
    }

    @Test
    public void isFull_true() {
        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        assertTrue(queue.isFull());
    }

    @Test
    public void isFull_false() {
        Queue queue = new Queue(1);
        assertFalse(queue.isFull());
    }

    @Test
    public void isEmpty_true() {
        Queue queue = new Queue(1);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        Queue queue = new Queue(2);
        queue.insert(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size() {
        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(5);
        assertEquals(2, queue.size());
    }
}
