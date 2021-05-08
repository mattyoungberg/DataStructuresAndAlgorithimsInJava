package com.mattyoungberg.Sorts;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int outer, inner, min;
        for(outer = 0; outer < array.length-1; outer++) {
            min = outer;
            for(inner = outer+1; inner < array.length; inner++)
                if (array[inner] < array[min])
                    min = inner;
            swap(array, outer, min);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
