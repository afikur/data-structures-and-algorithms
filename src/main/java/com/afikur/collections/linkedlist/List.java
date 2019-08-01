package com.afikur.collections.linkedlist;

public interface List {
    /**
     * Appends the specified element to the end of this list (optional operation).
     */
    boolean add(int data);

    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     */
    boolean add(int position, int data);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Returns true if this list contains the specified element.
     */
    boolean contains(int data);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     */
    boolean remove(int data);

    /**
     *R emoves the element at the specified position in this list.
     */
    boolean removeAt(int position);

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    int indexOf(int data);

    /**
     * Returns the number of elements in this list.
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     */
    boolean isEmpty();

    int[] toArray();
}
