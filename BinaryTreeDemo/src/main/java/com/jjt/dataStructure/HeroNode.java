package com.jjt.dataStructure;

/**
 * ClassName: HeroNode
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 19:21
 * @Version 1.0
 * Description:
 *              英雄树  的英雄结点
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     *  前序遍历
     *  TODO:
     *     1.先输出当前节点
     *     2.如果左子节点不为空，则递归进行前序遍历
     *     3.如果右子节点不为空，则递归进行前序遍历
     * */
    public void preOrder() {
        // 先输出父结点
        System.out.println(this);
        // 递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     *  中序遍历
     *  TODO:
     *     1.如果左子节点不为空，则递归进行前序遍历
     *     2.输出当前节点
     *     3.如果右子节点不为空，则递归进行前序遍历
     * */
    public void infixOrder() {
        // 1.如果左子节点不为空，则递归进行前序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //  2.输出当前节点
        System.out.println(this);
        // 3.如果右子节点不为空，则递归进行前序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
    /**
     *  后序遍历
     *  TODO:
     *     1.如果左子节点不为空，则递归进行前序遍历
     *     2.如果右子节点不为空，则递归进行前序遍历
     *     3.输出当前节点
     * */
    public void postOrder() {
        // 1.如果左子节点不为空，则递归进行前序遍历
        if(this.left != null) {
            this.left.postOrder();
        }
        // 2.如果右子节点不为空，则递归进行前序遍历
        if(this.right != null) {
            this.right.postOrder();
        }
        // 3.输出当前节点
        System.out.println(this);
    }

    /**
     *   前序遍历查找
     *   根据 英雄的 no 查找英雄
     *   找到返回 英雄节点   没有找到返回 null
     * */
    public HeroNode preOrderSearch(int no) {

        if(this.getNo() == no) {
            return this;
        }
        HeroNode res = null;
        if(this.left != null) {
            res = this.left.preOrderSearch(no);
            if(res !=null ) return res;
        }
        if(this.right != null) {
            return this.right.preOrderSearch(no);
        }
        return null;
    }

    /**
     *   中序遍历查找
     *   根据 英雄的 no 查找英雄
     *   找到返回 英雄节点   没有找到返回 null
     * */
    public HeroNode infixOrderSearch(int no) {
        HeroNode res = null;
        if(this.left != null) {
            res = this.left.infixOrderSearch(no);
            if(res !=null ) return res;
        }
        if(this.getNo() == no) {
            return this;
        }
        if(this.right != null) {
            return this.right.infixOrderSearch(no);
        }
        return null;
    }

    /**
     *   后序遍历查找
     *   根据 英雄的 no 查找英雄
     *   找到返回 英雄节点   没有找到返回 null
     * */
    public HeroNode postOrderSearch(int no) {
        HeroNode res = null;
        if(this.left != null) {
            res = this.left.postOrderSearch(no);
            if(res !=null ) return res;
        }

        if(this.right != null) {
            return this.right.postOrderSearch(no);
        }
        if(this.getNo() == no) {
            return this;
        }
        return null;
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
        if(this.left != null) {
            if (this.left.getNo() == no) {
                this.setLeft(null);
                return;
            }
            this.left.remove(no);
        }

        if(this.right != null) {
            if(this.right.getNo() == no) {
                this.setRight(null);
                return;
            }
            this.right.remove(no);
        }
    }

}
