package com.mattyoungberg.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void search_empty() {
        assertFalse(BinarySearch.search(new int[]{}, 1));
    }

    @Test
    public void search_oneFalse() {
        assertFalse(BinarySearch.search(new int[]{1}, 2));
    }

    @Test
    public void search_oneTrue() {
        assertTrue(BinarySearch.search(new int[]{1}, 1));
    }

    @Test
    public void search_True() {
        assertTrue(BinarySearch.search(new int[]{1, 3, 6, 8, 9, 14}, 9));
    }

    @Test
    public void search_False() {
        assertFalse(BinarySearch.search(new int[]{1, 3, 6, 8, 9, 14}, 4));
    }
}
