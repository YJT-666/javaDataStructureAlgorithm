package com.jjt.dataStructure.threadedBinaryTree;

import com.jjt.dataStructure.threadedBinaryTree.HeroNode;

/**
 * ClassName: ThreadedBinaryTree
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/10 11:48
 * @Version 1.0
 * Description:
 *        线索化二叉树
 *        - n个结点的二叉链表中含有n+1  【公式 2n-(n-1)=n+1】 个空指针域
 *           n个节点有2n个指针，但是n个节点之间相连只需要n-1个指针即可
 *        - 利用二叉链表中的空指针域，存放指向该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为“线索”）
 *        - 根据线索性质的不同，可分为前序线索二叉树、中序线索二叉树和后序线索二叉树
 *        - 一个结点的前一个结点，称为前驱结点
 *        - 一个结点的后一个结点，称为后继结点
 *        - 线索化后
 *          > left 指向的是左子树，也可能是指向的前驱节点
 *          > right指向的是右子树，也可能是指向后继节点
 */
public class ThreadedBinaryTree {
    private HeroNode root;  // 树的根节点

    // 为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre总是保留线索化节点的前驱节点
    private HeroNode pre = null;

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     *  前序遍历
     * */
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  中序遍历
     * */
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  后序遍历
     * */
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  前序遍历查找
     * */
    public HeroNode preOrderSearch(int no) {
        if(this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  中序遍历查找
     * */
    public HeroNode infixOrderSearch(int no) {
        if(this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  后序遍历查找
     * */
    public HeroNode postOrderSearch(int no) {
        if(this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            throw  new RuntimeException("二叉树为空");
        }
    }

    /**
     *  删除节点
     *  根据英雄的编号
     *  规定
     *  1）如果删除的节点是叶子节点，则删除该节点
     *  2）如果删除的节点是非叶子节点，则直接删除该子树
     *  TODO:
     *    二叉树是单向的，所以需要判断要删除的节点是否是当前节点的子节点
     * */
    public void remove(int no) {
        if(root == null) {
            return;
        }
        if(root.getNo() == no) {
            root = null;
            return;
        }
        root.remove(no);
    }


    /**
     *  编写对二叉树进行中序线索化的方法
     *
     *  node 就是当前需要进行线索化的节点
     * */
    private void threadNodesInfix(HeroNode node) {
        if(node == null) {
            return;
        }
        // 1. 先线索化左子树
        threadNodesInfix(node.getLeft());

        // 2. 线索化当前节点
          // 处理前驱节点
        if(node.getLeft() == null) {
            // 让当前节点的左指针，指向前驱节点
            node.setLeft(pre);
            // 修改当前节点左指针类型, 指向的是前驱节点
            node.setLeftType(1);
        }
          // 处理后继节点
        if(pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针，指向当前节点
            pre.setRight(node);
            // 修改前驱节点右指针类型, 指向的是后继节点
            pre.setRightType(1);
        }
        pre = node; // 每处理一个节点后，让当前节点是下一个线索化节点的前驱节点
        // 3. 线索化右子树
        threadNodesInfix(node.getRight());
    }

    /**
     *  编写对二叉树进行中序线索化的方法
     * */
    public void threadNodes() {
        this.threadNodesInfix(root);
    }

    /**
     *  遍历线索化二叉树
     * */
    public void threadedList() {
        // 定义一个变量，存储当前遍历的结点，从 root
        HeroNode node = root;

        while (node != null) {
            // 向左边循环查找 leftType = 1, 说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印当前这个结点
            System.out.println(node);
            // 线索遍历
            while (node.getRightType() == 1) {
                node = node.getRight();
                if(node != null) {
                    System.out.println(node);
                }
            }
            // 替换这个遍历的结点
            node = node.getRight();
        }
    }
}
