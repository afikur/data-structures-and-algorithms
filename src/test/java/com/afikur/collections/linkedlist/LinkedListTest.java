package com.afikur.collections.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testInsertAtEnd() {
        List list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        assertEquals(3, list.getLength());
    }

    @Test
    public void testIsEmpty() {
        List list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testLinkedListLength() {
        List list = new LinkedList();
        list.insertAtBegin(1);
        list.insertAtBegin(2);
        list.insertAtBegin(3);
        list.insertAtBegin(4);
        System.out.println(list);
        assertEquals(4, list.getLength());
    }
}
