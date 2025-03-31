package AB3;

import AB3.Interfaces.List;
import AB3.Provided.ListNode;

/**
 * A custom implementation of a singly linked list for storing {@code ListNode} elements.
 * The {@code BrailleLinkedList} class provides methods for adding, removing, and retrieving
 * elements from both the head and tail of the list, as well as methods for inserting and
 * removing elements at specific indices. It also includes methods for clearing the list.
 *
 * <p>This class is particularly designed to operate with {@code ListNode} objects which represent
 * nodes in a linked list, each containing a bitmap and a reference to the next node.</p>
 */
public class BrailleLinkedList implements List {
    private ListNode head;
    private ListNode tail;

    // TODO: (optional) variable declarations
    private int currentSize;

    /**
     * Constructor initializes an empty BrailleLinkedList.
     */
    public BrailleLinkedList() {
        head = tail = null;
        currentSize = 0;
    }

    /**
     * Returns the number of nodes in the BrailleLinkedList.
     *
     * @return the current size of the list.
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Adds the specified {@code ListNode} at the beginning of the linked list.
     * The new node becomes the head of the list. If the list was empty,
     * the new node is set as both the head and tail of the list.
     *
     * @param newNode the {@code ListNode} to be added at the beginning of the list.
     *                If {@code newNode} is {@code null}, the method does nothing.
     */
    @Override
    public void addFirst(ListNode newNode) {
        if (head != null) {
            newNode.setNext(head);
            head = newNode;
        } else
            head = tail = newNode;

        currentSize++;
    }

    /**
     * Retrieves the first node in the linked list.
     * If the list is empty, returns {@code null}.
     *
     * @return the head of the linked list, or {@code null} if the list is empty.
     */
    @Override
    public ListNode getFirst() {
        if (currentSize == 0) return null;

        return head;
    }

    /**
     * Removes and returns the first node in the linked list.
     * If the list is empty, returns {@code null}.
     * After removing the node, updates the head to the next node in the list.
     * If the list becomes empty after removal, the tail is also set to {@code null}.
     *
     * @return the first {@code ListNode} that was removed from the list,
     * or {@code null} if the list was empty.
     */
    @Override
    public ListNode removeFirst() {
        if (currentSize == 0) return null;

        ListNode temp = head;

        head = head.getNext();
        currentSize--;

        if (head == null)
            tail = null;

        return temp;
    }

    /**
     * Adds the specified {@code ListNode} to the end of the linked list.
     * If the list is empty, the new node becomes both the head and the tail
     * of the list. Otherwise, the new node is appended after the current tail.
     *
     * @param newNode the {@code ListNode} to be added at the end of the list.
     *                If {@code newNode} is {@code null}, the method does nothing.
     */
    @Override
    public void addLast(ListNode newNode) {
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        } else
            head = tail = newNode;

        currentSize++;
    }

    /**
     * Retrieves the last node in the linked list.
     * If the list is empty, returns {@code null}.
     *
     * @return the tail of the linked list, or {@code null} if the list is empty.
     */
    @Override
    public ListNode getLast() {
        if (currentSize == 0) return null;

        return tail;
    }

    /**
     * Removes and returns the last node in the linked list.
     * If the list is empty, returns {@code null}.
     * After removing the node, updates the tail to the previous node in the list.
     * If the list becomes empty after removal, both the head and tail are set to {@code null}.
     *
     * @return the last {@code ListNode} that was removed from the list,
     * or {@code null} if the list was empty.
     */
    @Override
    public ListNode removeLast() {
        if (currentSize == 0) return null;

        ListNode temp = tail;
        ListNode secondLast = head;

        while (head.getNext().getNext() != null)
            secondLast = secondLast.getNext();

        secondLast.setNext(null);

        currentSize--;

        if (tail == null)
            head = null;
        return temp;
    }

    /**
     * Retrieves the {@code ListNode} at the specified index in the linked list.
     * If the index is out of bounds, returns {@code null}.
     *
     * @param index the zero-based position of the node to retrieve.
     *              Must be greater than or equal to 0 and less than the size of the list.
     * @return the {@code ListNode} at the specified index, or {@code null} if the index is invalid.
     */
    @Override
    public ListNode get(int index) {
        if (index < 0 || index >= currentSize)
            return null;

        ListNode result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        return result;
    }

    /**
     * Inserts the specified {@code ListNode} at the given index in the linked list.
     * If the index is less than or equal to 0, the new node is added at the beginning of the list.
     * If the index is greater than or equal to the current size of the list, the new node is added at the end.
     * Otherwise, the new node is inserted at the specified position.
     *
     * @param newNode the {@code ListNode} to be inserted into the list.
     * @param index   the position at which the node is to be inserted.
     *                A value less than or equal to 0 results in the node being added at the start.
     *                A value greater than or equal to the current size of the list results in the node being
     *                added at the end.
     */
    @Override
    public void insert(ListNode newNode, int index) {

        if (index <= 0)
            this.addFirst(newNode);
        else if (index >= currentSize)
            this.addLast(newNode);
        else {
            ListNode temp = this.get(index - 1);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            currentSize++;
        }
    }


    /**
     * Removes and returns the {@code ListNode} at the specified index in the linked list.
     * If the index is less than 0, the first node is removed and returned.
     * If the index is greater than or equal to the size of the list, the last node is removed and returned.
     * Otherwise, the node at the specified index is removed and returned.
     * After removal, updates the linked list, including the head and tail references, if necessary.
     *
     * @param index the zero-based position of the node to remove. A value less than 0 results in the first node being removed;
     *              a value greater than or equal to the size of the list results in the last node being removed.
     * @return the {@code ListNode} that was removed from the list, or {@code null} if the list was empty.
     */
    @Override
    public ListNode remove(int index) {
        ListNode deletedNode;
        if (index <= 0) {
            deletedNode = head;
            this.removeFirst();
        } else if (index >= currentSize) {
            deletedNode = tail;
            this.removeLast();
        } else {
            deletedNode = this.get(index);

            ListNode previousNode = this.get(index - 1);
            ListNode nextNode = this.get(index + 1);
            previousNode.setNext(nextNode);
            currentSize--;
        }
        return deletedNode;
    }

    /**
     * Clears the BrailleLinkedList by removing all nodes.
     *
     * <p>This method sets the head and tail of the list to null,
     * effectively removing all elements from the list.</p>
     */
    @Override
    public void clear() {
        head = tail = null;
        currentSize = 0;
    }

    /**
     * Method is required for submission testing.
     * DO NOT EDIT.
     */
    @Override
    public ListNode debugGetHead() {
        return head;
    }

    /**
     * Method is required for submission testing.
     * DO NOT EDIT.
     */
    @Override
    public ListNode debugGetTail() {
        return tail;
    }

}

