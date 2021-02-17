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
        if (last != null)
            last.next = newLink;
        else
            first = newLink;
        last = newLink;
    }

    @Override
    public void deleteFirst() {
        if (first != null) {
            if (first == last)
                last = null;
            first = first.next;
        }
    }

    @Override
    public boolean search(int item) {
        Link current = first;
        while (current != null) {
            if (current.key == item)
                return true;
            current = current.next;
        }
        return false;
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
