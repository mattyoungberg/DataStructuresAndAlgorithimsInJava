package com.mattyoungberg.HashMaps;

import java.util.Arrays;

public class QuadraticHashMap {

    private final int[] hashMap;
    private final int hashMapSize;
    private int items;

    public QuadraticHashMap(int size) {
        this.hashMap = new int[size];
        Arrays.fill(this.hashMap, -1);
        this.hashMapSize = size;
    }

    public void insert(int value) {
        if (!isFull()) {
            int hashValue = hash(value);
            int step = 1;
            while (hashMap[hashValue] != -1) {
                hashValue = hashValue + ((int) Math.pow(step++, 2));
                hashValue %= hashMapSize;
            }
            hashMap[hashValue] = value;
            items++;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    public boolean find(int value) {
        int hashValue = hash(value);
        int step = 1;
        while (hashMap[hashValue] != -1) {
            if (hashMap[hashValue] == value)
                return true;
            hashValue = hashValue + ((int) Math.pow(step++, 2));
            hashValue %= hashMapSize;
        }
        return false;
    }

    public boolean delete(int value) {
        if (!isEmpty()) {
            int hashValue = hash(value);
            int step = 1;
            while (hashMap[hashValue] != -1) {
                if (hashMap[hashValue] == value) {
                    hashMap[hashValue] = -1;
                    items--;
                    return true;
                }
                hashValue++;
                hashValue %= hashMapSize;
            }
        }
        return false;
    }

    private int hash(int value) {
        return value % hashMapSize;
    }

    private boolean isFull() {
        return items == hashMapSize;
    }

    private boolean isEmpty() {
        return items == 0;
    }
}
