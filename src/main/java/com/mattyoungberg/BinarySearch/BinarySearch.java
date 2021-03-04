package com.mattyoungberg.BinarySearch;

public class BinarySearch {

    public static boolean search(int[] array, int value) {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound)
                return false;
            else if (array[currentIndex] == value)
                return true;
            else {
                if (array[currentIndex] < value)
                    lowerBound = currentIndex + 1;
                else
                    upperBound = currentIndex - 1;
            }
        }
    }
}
