package com.jjt.dataStructure.linkedList;

import com.jjt.dataStructure.node.ListNode;

/**
 * ClassName: MyLinkedList
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2023/12/24 18:15
 * @Version 1.0
 * Description:
 *
 *    链表数据结构
 *    1.链表是以节点的方式来存储数据的，属于链式存储
 *    2.每一个节点包含  data 域， 和 节点域
 *      data 域 指向节点的数据
 *      节点域 指向链表当中逻辑位置相邻的节点（内存地址不一定相邻）
 *      如果是单向链表：存在next域， next域用于指向下一个节点
 *      如果是双向链表：还会存储一个prev域，next域用于指向前一个节点
 *    3.链表的各个节点的存储不一定是连续的
 *    4.链表的头节点 head
 *      1)头节点不存放具体的数据，因此 data=null
 *      2)头节点的作用就是标识一个链表的开始，因此 next 指向链表的第一个节点
 *    5.链表就是一个简单容器，因此可以对容器内的链表进行
 *      1)插入节点
 *      2)删除节点
 *      3)修改节点
 *      4)查找节点
 *      5)获取链表当中的节点个数
 */
public interface MyLinkedList<T> {

    /**
     *  获取头节点
     *
     * @param node the node
     * @return the head
     */
    public ListNode<T> getHead();

    /**
     * 向链表尾部添加一个节点
     *
     * @param node the node
     */
    public void push(ListNode<T> node);

    /**
     * 在 refNode 节点后 添加 newNode节点
     *
     * @param refNode the ref node
     * @param newNode the new node
     */
    public void addNode(ListNode<T> refNode, ListNode<T> newNode);


    /**
     * 删除链表当中的指定节点
     *
     * @return the single linked node
     */
    public void pop(ListNode<T> node);

    /**
     * 删除链表尾部的节点，并返回删除的节点
     *
     * @return the single linked node
     */
    public ListNode<T> pop();

    /**
     * 删除链表当中的所有节点
     *
     * @return the single linked node
     */
    public void clear();

    /**
     * 查找单链表中第一个与data域值相等的节点
     *
     * @param data the data
     * @return the single linked node
     */
    public ListNode<T> find(T data);

    /**
     * 返回链表当中的节点个数
     *
     * @return the int
     */
    public int size();
}
