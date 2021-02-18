package com.mattyoungberg.LinkedLists;

import com.mattyoungberg.LinkedLists.Implementations.DoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void insertFirst_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        assertArrayEquals(new int[]{1}, doublyLinkedList.getList());
        assertNotNull(doublyLinkedList.first);
        assertNotNull(doublyLinkedList.last);
    }

    @Test
    public void insertFirst_populated() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(3);
        doublyLinkedList.insertFirst(2);
        assertArrayEquals(new int[]{2, 3, 1}, doublyLinkedList.getList());
    }

    @Test
    public void insertLast_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        assertArrayEquals(new int[]{1}, doublyLinkedList.getList());
        assertNotNull(doublyLinkedList.first);
        assertNotNull(doublyLinkedList.last);
    }

    @Test
    public void insertLast_populated() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertLast(2);
        assertArrayEquals(new int[]{1, 3, 2}, doublyLinkedList.getList());
    }

    @Test
    public void insert_firstAndLast() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertLast(15);
        assertArrayEquals(new int[]{10, 1, 5, 15}, doublyLinkedList.getList());
    }

    @Test
    public void insertAfter_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAfter(1, 2);  // Does nothing
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
    }

    @Test
    public void insertAfter_populatedAndExists() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertLast(12);
        doublyLinkedList.insertAfter(8, 5);
        assertArrayEquals(new int[] {1, 5, 8, 12}, doublyLinkedList.getList());
    }

    @Test
    public void insertAfter_populatedAndDoesntExist() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertLast(12);
        doublyLinkedList.insertAfter(8, 6);  // Does nothing
        assertArrayEquals(new int[] {1, 5, 12}, doublyLinkedList.getList());
    }

    @Test
    public void deleteFirst_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.deleteFirst();  // Does nothing
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
    }

    @Test
    public void deleteFirst_populatedOne() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.deleteFirst();
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
        assertNull(doublyLinkedList.first);
        assertNull(doublyLinkedList.last);
    }

    @Test
    public void deleteFirst_populatedMany() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertLast(15);
        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteFirst();
        assertArrayEquals(new int[]{5, 15}, doublyLinkedList.getList());
    }

    @Test
    public void deleteLast_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.deleteLast();  // Does nothing
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
    }

    @Test
    public void deleteLast_populatedOne() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.deleteLast();
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
        assertNull(doublyLinkedList.first);
        assertNull(doublyLinkedList.last);
    }

    @Test
    public void deleteLast_populatedMany() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertLast(15);
        doublyLinkedList.deleteLast();
        doublyLinkedList.deleteLast();
        assertArrayEquals(new int[]{10, 1}, doublyLinkedList.getList());
    }

    @Test
    public void deleteKey_empty() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.deleteKey(1);  // Does nothing
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
    }

    @Test
    public void deleteKey_one() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.deleteKey(1);
        assertArrayEquals(new int[]{}, doublyLinkedList.getList());
        assertNull(doublyLinkedList.first);
        assertNull(doublyLinkedList.last);
    }

    @Test
    public void deleteKey_many() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertLast(15);
        doublyLinkedList.deleteKey(5);
        doublyLinkedList.deleteKey(10);
        assertArrayEquals(new int[]{1, 15}, doublyLinkedList.getList());
    }
}
