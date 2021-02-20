package com.mattyoungberg.StacksAndQueues;

import com.mattyoungberg.StacksAndQueues.Implementations.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void push_pop() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void push_full() {
        Stack stack = new Stack(1);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void pop_empty() {
        Stack stack = new Stack(1);
        assertEquals(-1, stack.pop());
    }

    @Test
    public void peek() {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
    }

    @Test
    public void isEmpty_empty() {
        Stack stack = new Stack(1);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_notEmpty() {
        Stack stack = new Stack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isFull_notFull() {
        Stack stack = new Stack(2);
        stack.push(1);
        assertFalse(stack.isFull());
    }

    @Test
    public void isFull_Full() {
        Stack stack = new Stack(1);
        stack.push(1);
        assertTrue(stack.isFull());
    }
}
