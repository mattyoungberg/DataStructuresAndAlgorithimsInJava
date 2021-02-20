package com.mattyoungberg.LinkedLists.Implementations;

import com.mattyoungberg.LinkedLists.Interfaces.IDoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList implements IDoublyLinkedList {

    public Link first = null;
    public Link last = null;

    static class Link {
        int key;
        Link next = null;
        Link previous = null;

        public Link(int key) {
            this.key = key;
        }
    }

    @Override
    public void insertFirst(int item) {
        Link newLink = new Link(item);
        if (!isEmpty())
            first.previous = newLink;
        else
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    @Override
    public void insertLast(int item) {
        Link newLink = new Link(item);
        if (!isEmpty())
            last.next = newLink;
        else
            first = newLink;
        newLink.previous = last;
        last = newLink;
    }

    @Override
    public void insertAfter(int item, int after) {
        Link current = first;
        while (current != null && current.key != after)
            current = current.next;
        if (current == null)
            return;
        Link newLink = new Link(item);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
    }

    @Override
    public void deleteFirst() {
        if (!isEmpty()) {
            if (first == last)
                last = null;
            else
                first.next.previous = null;
            first = first.next;
        }
    }

    @Override
    public void deleteLast() {
        if (!isEmpty()) {
            if (first == last)
                first = null;
            else
                last.previous.next = null;
            last = last.previous;
        }
    }

    @Override
    public void deleteKey(int key) {
        Link current = first;
        while (current != null && current.key != key)
            current = current.next;
        if (current == null)
            return;
        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;
        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;
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
