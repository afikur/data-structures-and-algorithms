package com.afikur.collections.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testInsertAtEnd() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testIsEmpty() {
        List list = new LinkedList();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testLinkedListLength() {
        List list = new LinkedList();
        list.add(0,1);
        list.add(1, 2);

        assertEquals(2, list.size());
    }

    @Test
    public void testInsert() {
        List list = new LinkedList();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(1, 4);
        list.add(2, 5);
        list.add(3, 6);
        list.add(2, 11);

        assertArrayEquals(list.toArray(), new int[]{3, 4, 11, 5, 6, 2, 1});
    }
}
