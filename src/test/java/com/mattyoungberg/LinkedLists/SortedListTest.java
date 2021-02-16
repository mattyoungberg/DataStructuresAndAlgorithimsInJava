package com.mattyoungberg.LinkedLists;

import com.mattyoungberg.LinkedLists.Implementations.SortedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedListTest {

    @Test
    public void insert_empty() {
        SortedList sortedList = new SortedList();
        sortedList.insert(1);
        assertArrayEquals(new int[]{1}, sortedList.getList());
    }

    @Test
    public void insert_beginning() {
        SortedList sortedList = new SortedList();
        sortedList.insert(2);
        sortedList.insert(3);
        sortedList.insert(1);  // Test statement
        assertArrayEquals(new int[]{1, 2, 3}, sortedList.getList());
    }

    @Test
    public void insert_middle() {
        SortedList sortedList = new SortedList();
        sortedList.insert(1);
        sortedList.insert(3);
        sortedList.insert(2);  // Test statement
        assertArrayEquals(new int[]{1, 2, 3}, sortedList.getList());
    }

    @Test
    public void insert_end() {
        SortedList sortedList = new SortedList();
        sortedList.insert(1);
        sortedList.insert(2);
        sortedList.insert(3);  // Test statement
        assertArrayEquals(new int[]{1, 2, 3}, sortedList.getList());
    }

    @Test
    public void deleteFirst() {
        SortedList sortedList = new SortedList();
        sortedList.insert(2);
        sortedList.insert(1);
        sortedList.insert(3);
        sortedList.deleteFirst();
        assertArrayEquals(new int[]{2, 3}, sortedList.getList());
    }

    @Test
    public void isEmpty_true() {
        SortedList sortedList = new SortedList();
        assertTrue(sortedList.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        SortedList sortedList = new SortedList();
        sortedList.insert(1);
        assertFalse(sortedList.isEmpty());
    }

    @Test
    public void isEmpty_itemsRemoved() {
        SortedList sortedList = new SortedList();
        sortedList.insert(2);
        sortedList.insert(1);
        sortedList.insert(3);
        sortedList.deleteFirst();
        sortedList.deleteFirst();
        sortedList.deleteFirst();
        assertTrue(sortedList.isEmpty());
    }
}
