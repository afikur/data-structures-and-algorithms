package com.afikur.collections.linkedlist;

public interface List {
    void insertAtBegin(int data);
    void insertAtEnd(int data);
    void insert(int data, int position);
    ListNode removeFromBegin();
    ListNode removeFromEnd();
    void remove(int position);
    int getPosition(int data);
    int getLength();
    void clearList();
    boolean isEmpty();
}
