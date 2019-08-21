package com.daiql.queue.impl;

import com.daiql.queue.Queue;

/**
 * Author daiql
 * Date 2019/8/21 17:36
 * Description 基于链式结构实现队列
 */
public class LinkedQueue<E> implements Queue<E> {

    private class Node<E> {
        E e;
        Node<E> next;
        Node() {
        }
        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (size == 0) {
            Node<E> node = new Node<>(e,null);
            rear = node;
            front = node;
        } else {
            Node<E> currRear = rear;
            rear = new Node<>(e,null);
            currRear.next = rear;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new RuntimeException("队列为空！");
        }
        return front.e;
    }

    @Override
    public E poll() {
        if (empty()) {
            throw new RuntimeException("队列为空！");
        }
        Node<E> currNode = front;
        front = front.next;
        currNode.next = null;
        size--;
        return currNode.e;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        for (;!queue.empty();) {
            System.out.println(queue.poll());
        }
    }
}
