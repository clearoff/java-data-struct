package com.datastruct;

public class SkipList {

    private static final Integer MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node(); //带头链表

    private class Node<T> {
        T data;
        private Node forwards[] = new Node[MAX_LEVEL];
    }
}
