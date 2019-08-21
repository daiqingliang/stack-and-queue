package com.daiql.queue;

/**
 * Author daiql
 * Date 2019/8/21 16:36
 * Description 队列的接口
 * FIFO(first-in first-out)
 * 和java.util.Queue不同，这个队列接口不需要那么多相似的方法，比如：add() 和 offer()
 * 我们只要实现add()就可以
 */
public interface Queue<E> {

    /**
     * 入列，在队列尾部插入新的元素
     * @param e 需要插入的元素
     * @return 插入成功返回true,失败返回false
     */
    boolean add(E e);

    /**
     * 查看队列头元素
     * @return 队列头元素
     */
    E peek();

    /**
     * 删除并返回队列的头元素
     * @return 队列头元素
     */
    E poll();

    /**
     * 判断队列是否为空
     * @return 队列为空返回true,否则返回false
     */
    boolean empty();

    /**
     * 返回队列的长度
     * @return 队列的长度
     */
    int length();
}
