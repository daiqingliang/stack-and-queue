package com.daiql.stack.impl;

import com.daiql.stack.Stack;

import java.util.LinkedList;

/**
 * Author daiql
 * Date 2019/8/21 15:54
 * Description 基于LinkedList实现的栈
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public E push(E e) {
        linkedList.addFirst(e);
        return e;
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean empty() {
        return linkedList.isEmpty();
    }

    @Override
    public int search(Object o) {
        return linkedList.lastIndexOf(o) + 1;
    }

    @Override
    public int length() {
        return linkedList.size();
    }

    //Test
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }
        System.out.println(stack.search(9));
        for (;!stack.empty();) {
            System.out.println(stack.pop());
        }
    }
}
