package com.mattyoungberg.Sorts;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void sortTest() {
        int[] intArray = new int[]{5, 3, 0, 1, 9, 4};
        SelectionSort.selectionSort(intArray);
        assertArrayEquals(new int[]{0, 1, 3, 4, 5, 9}, intArray);
    }
}
