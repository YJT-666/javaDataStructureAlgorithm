package com.jjt.dataStructure;

/**
 * ClassName: BinaryTree
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 19:33
 * @Version 1.0
 * Description:
 *     二叉树
 */
public class BinaryTree {
    private HeroNode root;  // 树的根节点

    public BinaryTree(HeroNode root) {
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
}
