package com.daiql.stack.impl;

import com.daiql.stack.Stack;

import java.util.EmptyStackException;

/**
 * Author daiql
 * Date 2019/8/21 15:32
 * Description 链式存储实现栈
 */
public class LinkedStack<E> implements Stack<E> {

    //栈的节点
    private class Node<E> {
        E e;
        Node<E> next;
        Node() {}
        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
    }

    @Override
    public E push(E e) {
        top = new Node(e,top);
        size++;
        return e;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        Node<E> currNode = top;
        top = top.next;
        currNode.next = null; //需要释放原栈顶元素的next引用！
        size--;
        return currNode.e;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return top.e;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(Object o) {
        if (empty()) {
            throw new EmptyStackException();
        }
        int index = 1;
        for (Node node = top; node.next != null; node = node.next) {
            if (o == null) {
                if (node.e == null) {
                    return index;
                }
            }
            if (node.e == o || node.e.equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int length() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack();
        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }
        System.out.println(stack.search(9));
        for (;!stack.empty();) {
            System.out.println(stack.pop());
        }
    }
}
