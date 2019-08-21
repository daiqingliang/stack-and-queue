package com.daiql.queue.impl;

import com.daiql.queue.Queue;

/**
 * Author daiql
 * Date 2019/8/21 16:48
 * Description TODO
 */
public class ArrayQueue<E> implements Queue<E> {

    private Object[] data = null;
    private int maxSize;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue() {
        this(10);
    }
    public ArrayQueue(int initialCapacity) {
        if (initialCapacity > 0) {
            data = new Object[initialCapacity];
            front = rear = 0;
            maxSize = initialCapacity;
            size = 0;
        } else {
            throw new RuntimeException("初始化容量不能小于等于0！");
        }

    }

    @Override
    public boolean add(E e) {
        if (size == maxSize -1) {
            throw new RuntimeException("队列已满！");
        }
        data[rear] = e;
        rear = (rear + 1) % maxSize;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new RuntimeException("队列为空！");
        }
        return (E) data[front];
    }

    @Override
    public E poll() {
        if (empty()) {
            throw new RuntimeException("队列为空！");
        }
        E e = (E) data[front];
        data[front] = null;
        front = (front + 1) % maxSize;
        size--;
        return e;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        for (;!queue.empty();) {
            System.out.println(queue.poll());
        }
        System.out.println(queue.empty());
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.poll());
    }
}
