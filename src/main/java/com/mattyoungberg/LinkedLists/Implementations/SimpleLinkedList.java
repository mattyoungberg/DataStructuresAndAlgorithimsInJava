package com.mattyoungberg.LinkedLists.Implementations;

import com.mattyoungberg.LinkedLists.Interfaces.ISimpleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedList implements ISimpleLinkedList {

    public Link first = null;

    static class Link {
        public int key;
        public Link next;

        public Link(int key, Link next) {
            this.key = key;
            this.next = next;
        }
    }

    @Override
    public void insertFirst(int item) {
        first = new Link(item, first);
    }

    @Override
    public void deleteFirst() {
        if (first != null)
            first = first.next;
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
    public void delete(int item) {
        Link previous = first;
        Link current = first;
        while (current != null) {
            if (current.key == item) {
                if (current == first)
                    first = first.next;
                else
                    previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
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
