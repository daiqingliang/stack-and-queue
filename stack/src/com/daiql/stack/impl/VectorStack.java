package com.daiql.stack.impl;

import com.daiql.stack.Stack;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Author daiql
 * Date 2019/8/21 13:08
 * Description
 * 这是java JDK 中对栈的实现方式，通过继承Vector类来实现
 * java.util.Stack
 */
public class VectorStack<E> extends Vector<E> implements Stack<E> {


    public VectorStack() {
    }

    //入栈
    @Override
    public E push(E e) {
        addElement(e);
        return e;
    }

    //出栈
    @Override
    public E pop() {
        E e;
        int len = size();
        e = peek();
        removeElementAt(len - 1);
        return e;
    }

    //查看栈顶元素
    @Override
    public E peek() {
        int len = size();
        if (len == 0) {
            throw new EmptyStackException();
        }
        return elementAt(len - 1);
    }

    //判空
    @Override
    public boolean empty() {
        return size() == 0;
    }

    //查找
    @Override
    public int search(Object o) {
        int i = lastIndexOf(o);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    @Override
    public int length() {
        return size();
    }

    //Test
    public static void main(String[] args) {
        Stack<Integer> stack = new VectorStack();
        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }
        System.out.println(stack.search(9));
        for (;!stack.empty();) {
            System.out.println(stack.pop());
        }
    }
}
