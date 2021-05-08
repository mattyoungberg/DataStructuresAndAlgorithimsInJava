package com.mattyoungberg.Sorts;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] intArray = new int[]{5, 3, 0, 1, 9, 4};
        MergeSort.mergeSort(intArray);
        assertArrayEquals(new int[]{0, 1, 3, 4, 5, 9}, intArray);
    }

    @Test
    public void mergeSort_one() {
        int[] intArray = new int[]{1};
        MergeSort.mergeSort(intArray);
        assertArrayEquals(new int[]{1}, intArray);
    }

    @Test
    public void mergeSort_zero() {
        int[] intArray = new int[]{};
        MergeSort.mergeSort(intArray);
        assertArrayEquals(new int[]{}, intArray);
    }
}
