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
 *      DListNode 类抽象双链表的节点对象，从ListNode继承过来
 *      每一个节点包含：
 *            1. data 域 表示当前节点保存的数据
 *            2. next 域 表示当前节点的下一个节点
 *            3. prev 域 表示当前节点的上一个节点
 */
@Data
public class DListNode<T> extends ListNode<T>{
    private ListNode<T> prev;
}
