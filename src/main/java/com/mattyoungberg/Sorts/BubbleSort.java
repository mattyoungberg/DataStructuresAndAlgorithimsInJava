package com.mattyoungberg.Sorts;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int outer, inner;
        for (outer = array.length - 1; outer > 1; outer--)
            for (inner = 0; inner < outer; inner++)
                if (array[inner] > array[inner + 1])
                    swap(array, inner, inner + 1);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}