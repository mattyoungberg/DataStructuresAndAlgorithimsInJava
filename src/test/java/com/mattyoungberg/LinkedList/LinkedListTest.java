package com.mattyoungberg.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void insertFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        assertArrayEquals(linkedList.getList(), new int[]{1, 2, 3});
    }

    @Test
    public void deleteFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.deleteFirst();
        assertArrayEquals(linkedList.getList(), new int[]{2, 3});
    }

    @Test
    public void deleteFirst_empty() {
        LinkedList linkedList = new LinkedList();
        linkedList.deleteFirst();  // Shouldn't throw an exception; effectively does nothing
        assertArrayEquals(linkedList.getList(), new int[]{});
    }

    @Test
    public void search_true() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        assertTrue(linkedList.search(3));
    }

    @Test
    public void search_false() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        assertFalse(linkedList.search(4));
    }

    @Test
    public void search_empty() {
        LinkedList linkedList = new LinkedList();
        assertFalse(linkedList.search(-1));
    }

    @Test
    public void delete_exists() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.delete(2);
        assertArrayEquals(linkedList.getList(), new int[]{1, 3});
    }

    @Test
    public void delete_doesntExist() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.delete(4);
        assertArrayEquals(linkedList.getList(), new int[]{1, 2, 3});
    }

    @Test
    public void delete_oneItem() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(1);
        linkedList.delete(1);
        assertArrayEquals(linkedList.getList(), new int[]{});
    }

    @Test
    public void isEmpty_empty() {
        LinkedList linkedList = new LinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void isEmpty_notEmpty() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(1);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void isEmpty_afterAddsAndDeletes() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.deleteFirst();
        linkedList.deleteFirst();
        linkedList.deleteFirst();
        assertTrue(linkedList.isEmpty());
    }
}
