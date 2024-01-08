package com.jjt.dataStructure.linkedList.impl;

import com.jjt.dataStructure.linkedList.MyLinkedList;
import com.jjt.dataStructure.node.ListNode;

/**
 * ClassName: SingleLinkedList
 * Package: com.jjt.dataStructure.linkedList.impl
 *
 * @Author jjt
 * @Create 2023/12/24 19:17
 * @Version 1.0
 * Description:
 *      单向链表的实现
 *      head
 *      tail
 */
public class SingleLinkedList<T> implements MyLinkedList<T> {

    private ListNode<T>  head = null;
    private ListNode<T>  tail = null;

    private int count=0;

    public SingleLinkedList() {
        this.head = new ListNode();
        this.head.setData(null);
        this.head.setNext(null);
        this.tail = this.head;
        count=0;
    }

    @Override
    public ListNode getHead() {
        return this.head;
    }


    @Override
    public void push(ListNode node) {
        if(node == null) return;
        this.tail.setNext(node);
        this.tail=this.tail.getNext();
        this.tail.setNext(null);
        count++;
     }

    @Override
    public void addNode(ListNode refNode, ListNode newNode) {
        if(refNode == null || newNode == null) return;
        ListNode temp = refNode.getNext();
        refNode.setNext(newNode);
        newNode.setNext(temp);
        count++;
    }

    // TODO:
    @Override
    public void pop(ListNode node) {
        ListNode nodePrev = findNodePrev(node);
        if(nodePrev == null) {
            if(count > 0) {

            }
        }
    }

    @Override
    public ListNode pop() {
        if(head != tail) {
            // 有节点可删
            ListNode delNode = tail;
            ListNode nodePrev = findNodePrev(tail);
            nodePrev.setNext(null);
            tail = nodePrev;
            count--;
            return delNode;
        }
        return null;
    }

    @Override
    public void clear() {
        ListNode temp = head;
        while (temp != null) {
            ListNode temp1 = temp.getNext();
            temp.setNext(null);
            temp = temp1;
            count--;
        }
        count++; // 最后一次是没有删除元素的
    }

    @Override
    public ListNode find(Object data) {
        ListNode temp = head.getNext();
        while (temp != null) {
            if(temp.getData().equals(data)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }


    /**
     *   从 head 开始查找 node 节点的前一个节点，
     *   没找到返回 null
     *
     *   空链表: head==tail
     *      head -> 1 2 3 4 5
     *      tail
     *   链表只有一个元素 head.next == tail
     *      head -> 1    2   3   4   5
     *              tail
     *   链表至少含有2个以上的元素   head=tail
     *      head -> 1    2   3   4   5
     *                   tail
     * */
    private ListNode findNodePrev(ListNode node) {
        if(node == null) return null;

        ListNode temp = head;
        while (temp != null) {
            if(temp.getNext() == node) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
