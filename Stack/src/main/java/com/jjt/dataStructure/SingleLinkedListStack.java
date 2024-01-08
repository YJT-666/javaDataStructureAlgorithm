package com.jjt.dataStructure;

/**
 * ClassName: ArrayStack
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 15:00
 * @Version 1.0
 * Description:
 *      使用单向链表来模拟栈
 */
public class SingleLinkedListStack {

    // 用于表示链表当中的节点
    public class Node{
        public Integer data;
        public Node next;

        public Node(Integer data) {
            this.data = data;
            next = null;
        }

        public Node() {
            next = null;
        }
    }

    // 头节点
    private Node head = new Node();

    private int maxSize;  // 栈最大的大小

    public SingleLinkedListStack() {
        this.maxSize = 64;
    }

    public SingleLinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * TODO:
     *      判断栈是否满
     * */
    boolean isFull() {
        return getSize() >= maxSize;
    }

    /**
     * TODO:
     *      判断栈是否为空
     * */
    boolean isEmpty() {
        return getSize() <= 0;
    }

    /**
     * TODO:
     *      返回当前栈中的元素个数
     * */
    int getSize() {
        int cnt=0;
        Node temp = head.next;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    /**
     * TODO:
     *      入栈
     *      1. 栈顶指针先++
     *      2. 往数组当中存入数据
     * */
    void push(Integer e) {
        if(isFull()) {
            throw new RuntimeException("栈已满");
        }
        Node node = new Node(e);

        // 将元素加入到链表的头部
        node.next = head.next;
        head.next = node;
    }

    /**
     * TODO:
     *      出栈
     *      1. 返回栈顶的元素 array[top]
     *      2. 栈顶指针--
     * */
    Integer pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Node node = head.next;

        head.next = node.next;
        return node.data;
    }


    @Override
    public String toString() {
        if(isEmpty()) {
           return "ArrayStack{}";
        }
        String str =  "ArrayStack{";
        Node temp = head.next;
        while (temp != null) {
            str += temp.data;
            str += ",";
            temp = temp.next;
        }
        str = str.substring(0, str.length()-1);
        str+='}';

        return str;
    }
}
