package com.mattyoungberg.LinkedLists.Implementations;

import com.mattyoungberg.LinkedLists.Interfaces.IDoubleEndedList;

import java.util.ArrayList;
import java.util.List;

public class DoubleEndedList implements IDoubleEndedList {

    public Link first = null;
    public Link last = null;

    static class Link {
        int key;
        Link next;

        public Link(int key, Link next) {
            this.key = key;
            this.next = next;
        }
    }

    @Override
    public void insertFirst(int item) {
        first = new Link(item, first);
        if (last == null)
            last = first;
    }

    @Override
    public void insertLast(int item) {
        Link newLink = new Link(item, null);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    @Override
    public void deleteFirst() {
        if (!isEmpty()) {
            if (first == last)
                last = null;
            first = first.next;
        }
    }

    @Override
    public boolean search(int item) {
        Link current = first;
        while (current != null && current.key != item)
            current = current.next;
        return current != null;
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
