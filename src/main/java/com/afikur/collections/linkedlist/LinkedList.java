package com.afikur.collections.linkedlist;

public class LinkedList implements List {
    private int length;
    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    private void insertAtBegin(int data) {
        ListNode node = new ListNode(data);
        node.setNext(head);
        head = node;
        length += 1;
    }

    @Override
    public boolean add(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        }
        else {
            ListNode p = head;

            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(node);
        }
        length += 1;
        return true;
    }

    @Override
    public boolean add(int position, int data) {
        if(position < 0) {
            throw new IllegalArgumentException("Position can't be less than 0");
        }

        if(position > length) {
            position = length;
        }

        if(head == null || position == 0) {
            insertAtBegin(data);
            return true;
        } else {
            ListNode newNode = new ListNode(data);
            ListNode temp = head;
            for(int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            length += 1;
            return true;
        }
    }

    public ListNode removeFromBegin() {
        ListNode node = head;
        if(node != null) {
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }

    public ListNode removeFromEnd() {
        if(head == null) {
            return null;
        }
        ListNode p = head, q = head;
        if(p.getNext() == null) {
            head = null;
            length -= 1;
            return p;
        }

        while(p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        q.setNext(null);
        length -= 1;

        return p;
    }

    @Override
    public boolean remove(int data) {
        // if nothing in the list, do nothing
        if (head == null) {
            return false;
        }

        ListNode temp = head;
        while (temp != null) {
            if(temp.getData() == data) {
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }

        // reduce the length of the list
        length -= 1;
        return true;
    }

    @Override
    public int indexOf(int data) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if(temp.getData() == data) {
                return index;
            }
            index += 1;
            temp = temp.getNext();
        }
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
        if (position < 0) {
            position = 0;
        }

        if (position >= length) {
            position = length - 1;
        }

        // if nothing in the list, do nothing
        if (head == null)
            return false;

        // if removing the head element...
        if (position == 0) {
            head = head.getNext();
        }
        // else advance to the correct position and remove
        else {
            ListNode temp = head;
            for (int i=1; i<position; i+=1) {
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
        ListNode temp = head;
        int[] arr = new int[length];

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
