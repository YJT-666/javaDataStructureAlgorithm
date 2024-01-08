package com.jjt.dataStructure;

import java.util.Stack;

/**
 * ClassName: SingleLinkedList
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/5 17:01
 * @Version 1.0
 * Description:
 *              单向链表
 */
public class SingleLinkedList {

    // 头节点，不存放具体得到数据
    private HeroNode head = new HeroNode(0, null, null);
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
        HeroNode tempPre = head;   // 指向 temp 节点的前一个节点
        if (temp == null) {
            tempPre.next = heroNode;   // 这是往空链表加入第一个英雄
        }
        while (temp != null) {
            if (heroNode.no > temp.no) {
                tempPre = temp;
                temp = temp.next;
            } else if (heroNode.no == temp.no){
                throw new RuntimeException("编号排名已经存在");
            } else {
                // 找到了, 插入到 tempPre   temp  之间
                break;
            }
        }
        // 找到了, 插入到 tempPre   temp  之间
        tempPre.next = heroNode;
        heroNode.next = temp;
    }

    /**
     * TODO:
     *    根据 heroNode的 no 来修改英雄的信息
     *    链表当中不存在 no 编号的英雄，则报错
     * */
    public void update(HeroNode heroNode) {
        // 1. 查找英雄节点
        HeroNode temp = head.next;
        HeroNode tempPre = head;
        boolean isFind = false;
        while (temp != null) {
            if(heroNode.no == temp.no) {
                isFind = true;
                break; // 找到了
            }
            tempPre = temp;
            temp = temp.next;
        }
        if(!isFind) {
            throw new RuntimeException("没有找到编号：" + heroNode.no);
        }
        heroNode.next = temp.next;
        tempPre.next = heroNode;
    }

    /**
     *  TODO:
     *      根据编号删除节点
     * */
    public void del(int no) {
        // 1. 查找英雄节点
        HeroNode temp = head.next;
        HeroNode tempPre = head;
        boolean isFind = false;
        while (temp != null) {
            if(no == temp.no) {
                isFind = true;
                break; // 找到了
            }
            tempPre = temp;
            temp = temp.next;
        }
        if(isFind) {
            tempPre.next = temp.next;
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
     *      1. 先遍历整个链表，得到链表的长度 len   1 2 3 4 5
     *      2  遍历链表到第 len-k + 1 个元素就是要求的元素
     * */
    HeroNode findLastIndexNode(int k) {
        if(k<1) {
            throw new RuntimeException( "k=" + k + ", 但是k" + "不能小于1");
        }
        int len = getLength();
        int len2 = len - k + 1;
        if(len2 < 1) {
            throw new RuntimeException("链表不存在倒数第" + k + "元素");
        }
        HeroNode temp = head;
        for (int i = 0; i < len2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     *  TODO:
     *      获取倒数第 k 个节点
     *      采用双指针法      1 2 3 4 5
     *      1. 快指针先移动  k-1 步 后 慢指针指向第一个节点
     *      2. 快慢指针一起移动，快指针到尾节点时，慢指针指向的位置就是倒数第k个节点
     * */
    HeroNode findLastIndexNode2(int k) {
        if(k<1) {
            throw new RuntimeException( "k=" + k + ", 但是k" + "不能小于1");
        }

        HeroNode fastTemp = head.next;
        HeroNode slowTemp = head.next;

        for (int i = 0; i < k - 1; i++) {
            if(fastTemp == null) {
                throw new RuntimeException("链表不存在倒数第" + k + "元素");
            }
            fastTemp = fastTemp.next;
        }
        if(fastTemp == null) {
            throw new RuntimeException("链表不存在倒数第" + k + "元素");
        }
        while (fastTemp.next != null) {
            fastTemp = fastTemp.next;
            slowTemp = slowTemp.next;
        }
        return slowTemp;
    }

    /**
     * TODO:
     *      反转链表
     *      采用 头插法
     *      遍历整个链表，一个一个拿出，拿出的节点放在上一个拿出节点的前面
     *      需要用一个临时的节点做当前已经反转部分链表的头
     *
     * */
    public void reverse() {
        // 用于作为已反转部分的链表的头
        HeroNode reverseHead = new HeroNode(0, null, null);
        HeroNode temp = head.next;
        while (temp != null) {
            HeroNode tempNext = temp.next;  // 记录下一个需要反转的节点
            temp.next = reverseHead.next;   // 当前反转的节点插入到已经反转的链表头部
            reverseHead.next = temp;
            temp = tempNext;  // 取出下一个需要反转的节点
        }
        head.next = reverseHead.next;
    }


    /**
     *  TODO:
     *        合并两个有序链表 （排名有序）
     *        双指针法，每一个链表都使用一个指针，
     *        分别遍历，每一次取出小的节点，加入结果链表，而取出数据的链表的指针后移一个元素
     *        直到所有元素取出完毕
     *
     * */
    public void mergeOrderList(SingleLinkedList list) {
        HeroNode temp1 = head.next;
        HeroNode temp2 = list.getHead().next;
        HeroNode resTail = head;
        while (true) {
            if (temp1 != null && temp2 != null) {
                if(temp1.no < temp2.no) {
                    resTail.next = temp1;
                    temp1 = temp1.next;
                } else {
                    resTail.next = temp2;
                    temp2 = temp2.next;
                }
                resTail = resTail.next;
            } else if (temp1 != null) {
                resTail.next = temp1;
                break;
            } else if (temp2 != null) {
                resTail.next = temp2;
                break;
            } else {
                break;
            }
        }
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

    /**
     * TODO:
     *      逆序遍历打印链表
     *      利用 栈 先进后出的特点，将链表当中的元素依次入栈，然后出栈打印就可以实现逆序打印
     * */
    public void printListReverse() {
        System.out.println("[ ");
        Stack<HeroNode> heroNodesStack = new Stack<>();
        // 依次入栈
        HeroNode temp = head.next;
        while (temp != null) {
            heroNodesStack.push(temp);
            temp = temp.next;
        }
        // 依次出栈，并打印
        while (!heroNodesStack.empty()) {
            System.out.println("\t" + heroNodesStack.pop());
        }
        System.out.println(" ]");
    }

    public HeroNode getHead() {
        return head;
    }
}
