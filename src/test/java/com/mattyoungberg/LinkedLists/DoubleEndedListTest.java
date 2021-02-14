package com.mattyoungberg.LinkedLists;

import com.mattyoungberg.LinkedLists.Implementations.DoubleEndedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleEndedListTest {

    @Test
    public void insertFirst() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertFirst(1);
        doubleEndedList.insertFirst(2);
        doubleEndedList.insertFirst(3);
        assertArrayEquals(new int[]{3, 2, 1}, doubleEndedList.getList());
    }

    @Test
    public void insertLast() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertLast(1);
        doubleEndedList.insertLast(2);
        doubleEndedList.insertLast(3);
        assertArrayEquals(new int[]{1, 2, 3}, doubleEndedList.getList());
    }

    @Test
    public void insertFirstAndLast() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertFirst(1);
        doubleEndedList.insertFirst(2);
        doubleEndedList.insertFirst(3);
        doubleEndedList.insertLast(4);
        doubleEndedList.insertLast(5);
        doubleEndedList.insertLast(6);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5, 6}, doubleEndedList.getList());
    }

    @Test
    public void deleteFirst_notEmpty() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertFirst(1);
        doubleEndedList.insertFirst(2);
        doubleEndedList.insertFirst(3);
        doubleEndedList.deleteFirst();
        assertArrayEquals(new int[]{2, 1}, doubleEndedList.getList());
    }

    @Test
    public void deleteFirst_Empty() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.deleteFirst();  // Should do nothing
        assertArrayEquals(new int[]{}, doubleEndedList.getList());
    }

    @Test
    public void search_true() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertFirst(3);
        doubleEndedList.insertFirst(2);
        doubleEndedList.insertFirst(1);
        assertTrue(doubleEndedList.search(3));
    }

    @Test
    public void search_false() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        doubleEndedList.insertFirst(3);
        doubleEndedList.insertFirst(2);
        doubleEndedList.insertFirst(1);
        assertFalse(doubleEndedList.search(4));
    }

    @Test
    public void search_empty() {
        DoubleEndedList doubleEndedList = new DoubleEndedList();
        assertFalse(doubleEndedList.search(-1));
    }


}
