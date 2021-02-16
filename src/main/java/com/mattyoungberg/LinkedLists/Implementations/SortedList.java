package com.mattyoungberg.LinkedLists.Implementations;

import com.mattyoungberg.LinkedLists.Interfaces.ISortedList;

import java.util.ArrayList;
import java.util.List;

public class SortedList implements ISortedList {

    public Link first;

    static class Link {
        int key;
        Link next;

        public Link(int key, Link next) {
            this.key = key;
            this.next = next;
        }
    }

    @Override
    public void insert(int item) {
        Link newLink = new Link(item, null);
        Link previous = null;
        Link current = first;
        while (current != null && item > current.key) {
            previous = current;
            current = current.next;
        }
        if (previous == null)  // at beginning of list
            first = newLink;
        else  // Either in the middle or at the end
            previous.next = newLink;
        newLink.next = current;
    }

    @Override
    public void deleteFirst() {
        if (first != null)
            first = first.next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int[] getList() {
        List<Integer> list = new ArrayList<>();
        Link current = first;
        while (current != null) {
            list.add(current.key);
            current = current.next;
        }
        int[] intArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            intArray[i] = list.get(i);
        return intArray;
    }
}
