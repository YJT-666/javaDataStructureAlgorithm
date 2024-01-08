package com.jjt.dataStructure.node;

import lombok.Data;

/**
 * ClassName: ListNode
 * Package: com.jjt.dataStructure.node
 *
 * @Author jjt
 * @Create 2023/12/24 18:49
 * @Version 1.0
 * Description:
 *
 *      listNode 类抽象链表的节点对象
 *      每一个节点包含：
 *            1. data 域 表示当前节点保存的数据
 *            2. next 域 表示当前节点的下一个节点
 *       该类可以表示单链表的节点
 *       可以被双链表的节点继承添加prev 域来表示双链表的节点
 */
@Data
public class ListNode<T> {
    private T data = null;
    private ListNode<T> next = null;
}
