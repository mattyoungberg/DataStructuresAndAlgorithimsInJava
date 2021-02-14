package com.mattyoungberg.LinkedLists;

import com.mattyoungberg.LinkedLists.Implementations.SimpleLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void insertFirst() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        assertArrayEquals(simpleLinkedList.getList(), new int[]{1, 2, 3});
    }

    @Test
    public void deleteFirst() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.deleteFirst();
        assertArrayEquals(simpleLinkedList.getList(), new int[]{2, 3});
    }

    @Test
    public void deleteFirst_empty() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.deleteFirst();  // Shouldn't throw an exception; effectively does nothing
        assertArrayEquals(simpleLinkedList.getList(), new int[]{});
    }

    @Test
    public void search_true() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        assertTrue(simpleLinkedList.search(3));
    }

    @Test
    public void search_false() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        assertFalse(simpleLinkedList.search(4));
    }

    @Test
    public void search_empty() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        assertFalse(simpleLinkedList.search(-1));
    }

    @Test
    public void delete_exists() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.delete(2);
        assertArrayEquals(simpleLinkedList.getList(), new int[]{1, 3});
    }

    @Test
    public void delete_doesntExist() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.delete(4);
        assertArrayEquals(simpleLinkedList.getList(), new int[]{1, 2, 3});
    }

    @Test
    public void delete_oneItem() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.delete(1);
        assertArrayEquals(simpleLinkedList.getList(), new int[]{});
    }

    @Test
    public void isEmpty_empty() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        assertTrue(simpleLinkedList.isEmpty());
    }

    @Test
    public void isEmpty_notEmpty() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(1);
        assertFalse(simpleLinkedList.isEmpty());
    }

    @Test
    public void isEmpty_afterAddsAndDeletes() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.deleteFirst();
        simpleLinkedList.deleteFirst();
        simpleLinkedList.deleteFirst();
        assertTrue(simpleLinkedList.isEmpty());
    }
}
