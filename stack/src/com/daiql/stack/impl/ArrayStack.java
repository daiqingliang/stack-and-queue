package com.daiql.stack.impl;

import com.daiql.stack.Stack;

import java.util.EmptyStackException;

/**
 * Author daiql
 * Date 2019/8/21 14:06
 * Description 基于数组的栈实现
 */
public class ArrayStack<E> implements Stack<E> {

    private Object[] elementDate = null;
    private int maxSize;
    private int top;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int initSize) {
        if (initSize > 0) {
            elementDate = new Object[initSize];
            this.maxSize = initSize;
            this.top = -1;
        } else {
            throw new RuntimeException("初始化栈容量不能为空！");
        }

    }

    @Override
    public E push(E e) {
        if (top == maxSize -1) {
            Object[] array = new Object[maxSize * 2];
            System.arraycopy(elementDate, 0, array, 0, maxSize);
            elementDate = array;
            maxSize = elementDate.length;
        }
        elementDate[++top] = e;
        return e;
    }

    @Override
    public E pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        if (top > 0 && maxSize > 20) {
            reSize();
        }
        E e = (E)elementDate[top];
        elementDate[top--] = null;
        return e;
    }

    //重新调整大小
    private void reSize() {
        //当元素个数小于数组长度的三分之一时，把数组大小降低当原来的二分之一
        int length = maxSize/2;
        if (top < maxSize/3) {
            Object[] array = new Object[length];
            System.arraycopy(elementDate, 0, array, 0, top + 1);
            elementDate = array;
            maxSize = length;
        }
    }

    @Override
    public E peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return (E)elementDate[top];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    /*unCheck*/
    @Override
    public int search(Object o) {
        if (top == -1) {
            throw new EmptyStackException();
        }
        if ( o == null) {
            for (int i = top; i >= 0; i--) {
                if (elementDate[i] == null) {
                    return top - i + 1;
                }
            }
        } else {
            for (int i = top; i >= 0; i--) {
                if (o.equals(elementDate[i])) {
                    return top - i + 1;
                }
            }
        }

        return -1;
    }

    @Override
    public int length() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 1; i <= 2000; i++) {
            stack.push(i);
        }
        System.out.println(stack.search(9));
        for (;!stack.empty();) {
            System.out.println(stack.pop());
        }
    }
}
