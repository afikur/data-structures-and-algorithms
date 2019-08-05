package com.afikur.collections.linkedlist;

public class LinkedList implements List {
    private int length;
    private ListNode head;

    @Override
    public boolean add(int data) {
        ListNode node = new ListNode(data);

        // if list is empty head and new node is the same
        if(head == null) {
            head = node;
        }
        else {
            // advance to the last node
            ListNode p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }

            // add newNode in the list
            p.setNext(node);
        }

        // increment list length
        length += 1;

        return true;
    }

    @Override
    public boolean add(int position, int data) {
        // if position is less then zero just ignore the value and set to zero
        if(position < 0) {
            position = 0;
        }

        // if position is greater than the list size
        // just ignore the position and set position equal to it's length
        if(position > length) {
            position = length;
        }

        ListNode newNode = new ListNode(data);
        // if list is already empty or position is zero
        if(head == null || position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            ListNode temp = head;

            // advance to the correct position and add
            for(int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        // increment list length
        length += 1;

        return true;
    }

    @Override
    public boolean remove(int data) {
        // if nothing in the list, do nothing
        if (head == null) {
            return false;
        }

        // if data is the head element
        if(head.getData() == data) {
            head = head.getNext();
            // reduce the length of the list
            length -= 1;
            return true;
        }

        // advance to the correct node and remove
        ListNode temp = head, q = head;
        while (temp.getNext() != null) {

            if(temp.getNext().getData() == data) {
                q.setNext(temp.getNext().getNext());
            }
            q = temp;
            temp = temp.getNext();
        }

        // reduce the length of the list
        length -= 1;
        return true;
    }

    @Override
    public int indexOf(int data) {
        int index = 0;

        // advance to the correct node and return the index number
        ListNode temp = head;
        while (temp != null) {
            if(temp.getData() == data) {
                return index;
            }
            index += 1;
            temp = temp.getNext();
        }

        // if data isn't found in the list
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(int data) {
        ListNode temp = head;
        while (temp != null) {
            if(temp.getData() == data) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean removeAt(int position) {
        // if position is less then zero just ignore the value and set to zero
        if (position < 0) {
            position = 0;
        }

        // if position is more than the length of the list
        // ignore the value and set the position to the the last node
        if (position >= length) {
            position = length - 1;
        }

        // if nothing in the list, do nothing
        if (head == null)
            return false;

        // if removing the head element
        if (position == 0) {
            head = head.getNext();
        }
        // else advance to the correct position and remove
        else {
            ListNode temp = head;
            for (int i=1; i < position; i+=1) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        // reduce the length of the list
        length -= 1;
        return true;
    }

    @Override
    public int[] toArray() {
        // create a array of size list length
        int[] arr = new int[length];

        ListNode temp = head;
        // iterate the whole list and push the data in the array
        for(int i = 0; temp != null; i++) {
            arr[i] = temp.getData();
            temp = temp.getNext();
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (head == null) {
            return result.append("]").toString();
        }
        result.append(head.getData());
        ListNode temp = head.getNext();
        while (temp != null) {
            result.append(",").append(temp.getData());
            temp = temp.getNext();
        }
        return result.append("]").toString();
    }
}
