package com.afikur.collections.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testAdd() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(4, list.size());
        assertArrayEquals(new int[]{1,2,3,4}, list.toArray());
    }

    @Test
    public void testAddInSpecifiedPosition() {
        List list = new LinkedList();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(1, 4);
        list.add(2, 5);
        list.add(3, 6);
        list.add(2, 11);

        assertArrayEquals(new int[]{3, 4, 11, 5, 6, 2, 1}, list.toArray());
    }

    @Test
    public void testRemove() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(2);
        assertFalse(list.contains(2));

        list.remove(1);
        assertFalse(list.contains(1));

//        list.remove(4);
//        assertFalse(list.contains(1));
    }

    @Test
    public void testIsEmpty() {
        List list = new LinkedList();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertTrue(list.isEmpty());
        assertArrayEquals(new int[]{}, list.toArray());
    }

    @Test
    public void testLinkedListLength() {
        List list = new LinkedList();
        list.add(0,1);
        list.add(1, 2);

        assertEquals(2, list.size());
    }

    @Test
    public void testContains() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i = 1; i <= 3; i++) {
            assertTrue(list.contains(i));
        }
        assertFalse(list.contains(4));
    }
}
