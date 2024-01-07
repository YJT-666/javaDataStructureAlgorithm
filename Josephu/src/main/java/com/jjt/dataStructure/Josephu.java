package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Josephu
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 13:50
 * @Version 1.0
 * Description:
 *      使用单向循环链表解决约瑟夫问题：
 *          设编号为1，2，… n的n个人围坐一圈，
 *          约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 *          它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，
 *          求由此产生一个出队编号的序列。
 */
public class Josephu {

    private Boy first;  // 指向环形链表的第一个节点

    public Josephu(int nums) {
        createCircleLinkedList(nums);  // 创建环形链表
    }

    public Josephu() {
        createCircleLinkedList(5);  // 创建环形链表
    }

    /**
     *    创建一个单向环形链表
     *      nums  表示创建的环形链表的节点个数
     * */
    public void createCircleLinkedList(int nums) {
        if (nums < 1) {
            throw new RuntimeException("nums 不能小于1");
        }
        first = new Boy(1);
        first.setNext(first);   // 形成环形
        Boy curBoy = first;     // 指向环形链表的最后一个节点的位置
        for (int i = 1; i < nums; i++) {
            Boy boy = new Boy(i + 1);
            curBoy.setNext(boy);
            curBoy=curBoy.getNext();
            curBoy.setNext(first);
        }
    }

    /**
     *  TODO:
     *      报数 m ，出圈
     *      1首先是是确定出圈的boy
     *          1. 创建一个last指针，指向环形链表的最后一个元素
     *          2. 当 boy 报数时，让first和last同时移动 m-1 次
     *             这时，first 指向的boy 出圈
     *      2对boy进行出圈
     *          first = first.next
     *          last.next=first
     *          这样，原来的first指向的节点就会没有任何引用，就会被GC回收了
     *
     *       对于只剩下一个元素的情况，需要特殊处理，直接将其出圈
     * */
    public void popCircle(int m) {
        ArrayList<Boy> boyList = new ArrayList<>();  // 保存出圈的boy
        Boy last = null;
        Boy temp = first;
        while (temp != null) {
            if(temp.getNext() == first) {
                last = temp;
                break;
            }
            temp = temp.getNext();
        }
        if (last==null) throw new RuntimeException("循环队列为空！");

        while(first != null) {
            // 还有元素可以出圈
            if(first.getNext() == first) {
                // 判断是否只剩下一个元素, 一个元素直接出圈
                boyList.add(first);
                first = null;
            } else {
                // 1 报数
                for (int i = 0; i < m - 1; i++) {
                    first=first.getNext();
                    last=last.getNext();
                }
                // 2 出圈
                boyList.add(first);
                first = first.getNext();
                last.setNext(first);
            }
        }
        // 打印出圈结果
        System.out.println("res:");
        System.out.println(boyList);
    }

    /**
     *  TODO:
     *      遍历环形链表
     * */
    public void printCircleLinkedList() {
        System.out.println("[");
        Boy temp = first;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
            if(temp == first) break;
        }
        System.out.println("]");
    }

}
