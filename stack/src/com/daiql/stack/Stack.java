package com.daiql.stack;

/**
 * Author daiql
 * Date 2019/8/21 13:08
 * Stack接口，任何Stack的实现类都要实现该接口中的方法
 * FILO (first-in last-out) 先进后出
 */
public interface Stack<E> {

    /**
     * 入栈，把元素e压入栈顶
     * @param e 要入栈的元素
     * @return 返回该元素
     */
    E push(E e);

    /**
     * 出栈，删除并返回栈顶元素
     * @return 栈顶元素
     * @throws java.util.EmptyStackException 如果为栈为空时
     */
    E pop();

    /**
     * 查看栈顶元素，但是不删除
     * @return 栈顶元素
     * @throws java.util.EmptyStackException 如果为栈为空时
     */
    E peek();

    /**
     * 检查栈是否为空
     * @return 如果栈为空，返回true;否则，返回false
     */
    boolean empty();

    /**
     * 从栈顶开始往下搜索，返回找到元素的位置，栈顶基数为 1
     * @param o 要搜索的元素
     * @return 元素相对于栈顶的位置（栈顶基数为1）
     */
    int search(Object o);

    /**
     * 返回当前栈的长度
     * @return 栈的长度
     */
    int length();
}
