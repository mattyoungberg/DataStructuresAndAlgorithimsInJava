package com.mattyoungberg.Sorts;

public class QuickSort {

    public static void quickSort(int[] array) {
        recQuickSort(array, 0, array.length-1);
    }

    private static void recQuickSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(array, left, right);
        else {
            int median = medianOfThree(array, left, right);
            int partition = partitionIt(array, left, right, median);
            recQuickSort(array, left, partition-1);
            recQuickSort(array, partition+1, right);
        }
    }

    private static void manualSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size == 2) {
            if (array[left] > array[right])
                swap(array, left, right);
        } else if (size == 3) {
            if (array[left] > array[right-1])
                swap(array, left, right-1);
            if (array[left] > array[right])
                swap(array, left, right);
            if (array[left+1] > array[right])
                swap(array, left+1, right);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int medianOfThree(int[] array, int left, int right) {
        int center = (right + left) / 2;
        if (array[left] > array[center])
            swap(array, left, center);
        if (array[left] > array[right])
            swap(array, left, right);
        if (array[center] > array[right])
            swap(array, center, right);
        swap(array, center, right-1);
        return array[right-1];
    }

    private static int partitionIt(int[] array, int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while(true) {
            while (array[++leftPtr] < pivot);
            while (array[--rightPtr] > pivot);
            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr, rightPtr);
        }
        swap(array, leftPtr, right-1);
        return leftPtr;
    }
}
