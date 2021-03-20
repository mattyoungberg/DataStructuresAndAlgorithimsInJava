package com.mattyoungberg.MergeSort;

public class MergeSort {

    public static void mergeSort(int[] array) {
        int arrayLength = array.length;
        if (arrayLength < 2)
            return;
        int midPoint = arrayLength / 2;

        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[arrayLength - midPoint];
        for (int i = 0; i < midPoint; i++)
            leftArray[i] = array[i];
        for (int j = midPoint; j < arrayLength; j++)
            rightArray[j - midPoint] = array[j];

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }
        while (i < leftLength)
            array[k++] = leftArray[i++];
        while (j < rightLength)
            array[k++] = rightArray[j++];
    }
}