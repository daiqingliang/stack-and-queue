package com.daiql.queue.impl;

import com.daiql.queue.Queue;

import java.util.LinkedList;

/**
 * Author daiql
 * Date 2019/8/21 17:53
 * Description 基于LinkedList来实现队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> queue = new LinkedList<>();

    @Override
    public boolean add(E e) {
        return queue.add(e);
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public E poll() {
        return queue.poll();
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public int length() {
        return queue.size();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        for (;!queue.empty();) {
            System.out.println(queue.poll());
        }
    }
}
