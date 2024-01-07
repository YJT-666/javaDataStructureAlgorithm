package com.jjt.dataStructure;

/**
 * ClassName: DoubleLinkedList
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/5 22:18
 * @Version 1.0
 * Description:
 *          双向链表
 */
public class DoubleLinkedList {

    private HeroNode head;

    public DoubleLinkedList() {
        head = new HeroNode();
    }

    public HeroNode getHead() {
        return head;
    }





    /**
     * TODO：
     *      添加节点到单向链表尾部
     *      不考虑编号顺序
     *      1. 找到当前链表的最后节点
     *      2. 将最后节点的next指向新的节点
     * */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * TODO:
     *      根据英雄的排名 no 来向链表当中添加英雄
     *      1. 根据 heroNode 的排名找到要插入的位置
     *          ① 链表当中已经存在这个排名，报错
     *      2. 插入
     *          修改指针的指向
     * */
    public void addByNo(HeroNode heroNode) {
        HeroNode temp = head.next;
        if (temp == null) {
            // 这是往空链表加入第一个英雄
           head.next = heroNode;
           heroNode.pre = head;
           return;
        }
        while (temp != null) {
            if (heroNode.no > temp.no) {
                temp = temp.next;
            } else if (heroNode.no == temp.no){
                throw new RuntimeException("编号排名已经存在");
            } else {
                // 找到了, 插入到 temp 之前
                break;
            }
        }
        // 找到了, 插入到  temp 之前
        //            p    temp
        //               o
        heroNode.pre = temp.pre;
        heroNode.next = temp;
        temp.pre.next = heroNode;
        temp.pre = heroNode;
    }


    /**
     * TODO:
     *    根据 heroNode的 no 来修改英雄的信息
     *    链表当中不存在 no 编号的英雄，则报错
     * */
    public void update(HeroNode heroNode) {
        // 1. 查找英雄节点
        HeroNode temp = head.next;
        boolean isFind = false;
        while (temp != null) {
            if(heroNode.no == temp.no) {
                isFind = true;
                break; // 找到了
            }
            temp = temp.next;
        }
        if(!isFind) {
            throw new RuntimeException("没有找到编号：" + heroNode.no);
        }
        // 2 修改节点
        //  p t  n
        //    o
        heroNode.next = temp.next;
        heroNode.pre = temp.pre;
        temp.pre.next = heroNode;
        if(temp.next != null) {
            temp.next.pre = heroNode;
        }
    }

    /**
     *  TODO:
     *      根据编号删除节点
     * */
    public void del(int no) {
        // 1. 查找英雄节点
        HeroNode temp = head.next;
        boolean isFind = false;
        while (temp != null) {
            if(no == temp.no) {
                isFind = true;
                break; // 找到了
            }
            temp = temp.next;
        }
        if(isFind) {
            //    p t n
            temp.pre.next = temp.next;
        }
    }

    /*
     *  获取链表长度
     * */
    public int getLength() {
        HeroNode temp = head.next;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    /**
     *  TODO:
     *      获取倒数第 k 个节点
     *      先遍历到链表尾部，在往前遍历k个节点即可
     *
     * */
    HeroNode findLastIndexNode(int k) {
        if(k<1) {
            throw new RuntimeException( "k=" + k + ", 但是k" + "不能小于1");
        }
        HeroNode temp = head.next;

        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        for (int i = 0; i < k - 1; i++) {
            temp = temp.pre;
            if(temp == null || temp == head) {
                throw new RuntimeException("链表不存在倒数第" + k + "元素");
            }
        }
        return temp;
    }



    /**
     * TODO：
     *      遍历打印链表
     * */
    public void printList() {

        System.out.println("[ ");
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println("\t" + temp);
            temp = temp.next;
        }
        System.out.println(" ]");
    }
}
