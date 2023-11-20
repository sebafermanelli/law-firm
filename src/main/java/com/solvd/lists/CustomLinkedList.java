package com.solvd.lists;

import java.util.Comparator;

public class CustomLinkedList<T> {
  private Node<T> head;  // Initial node of the list
  private int size;      // Size of the list

  // Method to add an element to the list
  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    size++;
  }

  // Method to remove an element from the list
  public void remove(T data) {
    if (head == null) {
      return;
    }

    if (head.data.equals(data)) {
      head = head.next;
      size--;
      return;
    }

    Node<T> current = head;
    Node<T> previous = null;

    while (current != null && !current.data.equals(data)) {
      previous = current;
      current = current.next;
    }

    if (current != null && previous != null) {
      previous.next = current.next;
      size--;
    }
  }

  // Method to sort the list using the merge sort algorithm
  public void sort(Comparator<T> comparator) {
    if (head == null || head.next == null) {
      return; // Already sorted or the list is empty
    }

    head = mergeSort(head, comparator);
  }

  private Node<T> mergeSort(Node<T> start, Comparator<T> comparator) {
    if (start == null || start.next == null) {
      return start;
    }

    Node<T> middle = findMiddle(start);
    Node<T> secondHalf = middle.next;
    middle.next = null;

    Node<T> left = mergeSort(start, comparator);
    Node<T> right = mergeSort(secondHalf, comparator);

    return merge(left, right, comparator);
  }

  private Node<T> merge(Node<T> left, Node<T> right, Comparator<T> comparator) {
    Node<T> result = null;

    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }

    if (comparator.compare(left.data, right.data) <= 0) {
      result = left;
      result.next = merge(left.next, right, comparator);
    } else {
      result = right;
      result.next = merge(left, right.next, comparator);
    }

    return result;
  }

  private Node<T> findMiddle(Node<T> start) {
    if (start == null) {
      return null;
    }

    Node<T> slow = start;
    Node<T> fast = start.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // Method to display the elements of the list
  public void display() {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Method to get the size of the list
  public int size() {
    return size;
  }

  private static class Node<T> {
    T data;            // Node data
    Node<T> next;      // Reference to the next node

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
}
