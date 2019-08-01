package com.afikur.collections.linkedlist;

public class LinkedList implements List {
    private int length;
    private ListNode head;

    @Override
    public void insertAtBegin(int data) {
        ListNode node = new ListNode(data);
        node.setNext(head);
        head = node;
        length += 1;
    }

    @Override
    public void insertAtEnd(int data) {
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
    }

    @Override
    public void insert(int data, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("Position can't be less than 0");
        }

        if(position > length) {
            position = length;
        }

        if(head == null || position == 0) {
            insertAtBegin(data);
        } else {
            ListNode newNode = new ListNode(data);
            ListNode temp = head;
            for(int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    @Override
    public ListNode removeFromBegin() {
        ListNode node = head;
        if(node != null) {
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }

    @Override
    public ListNode removeFromEnd() {
        if(head == null) {
            return null;
        }
        ListNode p = head, q = null;
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
    public void remove(int position) {

    }

    @Override
    public int getPosition(int data) {
        return 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void clearList() {
        head = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        String result = "[";
        if (head == null) {
            return result+"]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while (temp != null) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}
