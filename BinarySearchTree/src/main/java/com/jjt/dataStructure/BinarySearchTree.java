package com.jjt.dataStructure;

import java.util.Objects;

/**
 * ClassName: BinarySearchTree
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/16 14:37
 * @Version 1.0
 * Description:
 *              二叉排序（搜索）树实现
 *
 *              二叉排序树满足：
 *                  left.value < parent.value < right.value
 */
public class BinarySearchTree {

    public static class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        /**
         *  递归
         *      添加结点, 满足二叉排序树
         * */
        public void add(Node node) {
            if(node == null) return;

            if(node.value < this.value) {
                if(left == null) {
                    left=node;
                }else {
                    left.add(node);
                }
            } else {
                if(right == null) {
                    right=node;
                } else {
                    right.add(node);
                }
            }
        }


        /**
         *  查找结点
         * */
        public Node search(Node node) {
            if(value == node.getValue()) {
                return this;
            } else if(node.getValue() < value && left != null) {
                // node值小于当前结点，应该向左边查找
                return left.search(node);
            } else if(node.getValue() >= value && right != null) {
                // node值大于等于当前结点，应该向右边查找
                return right.search(node);
            } else {
                return null;  // 不存在该节点
            }
        }
        /**
         *  查找结点的父节点
         * */
        public Node getParnet(Node node) {

            if(node.getValue() < value && left != null) {
                // node 可能是 当前结点的左子节点
                if(left.getValue() == node.getValue()) {
                    return this;   // 该节点是 node 的父节点
                } else {
                    return left.getParnet(node);  // 递归向左查找
                }
            } else if(node.getValue() >= value && right != null) {
                // node 可能是 当前结点的右子节点
                if(right.getValue() == node.getValue()) {
                    return this;  // 该节点是 node 的父节点
                } else {
                    return right.getParnet(node); // 递归向右查找
                }
            } else {
                return null;// 该节点不是 node 的父节点
            }
        }
        /**
         *  以当前结点为起始路径，获取最小的结点
         * */
        public Node getMinNode() {
            if(this.left == null) {
                return this;
            } else {
                return left.getMinNode();
            }
        }

        /**
         *  以当前结点为起始路径，获取最大的结点
         * */
        public Node getMaxNode() {
            if(this.right == null) {
                return this;
            } else {
                return left.getMaxNode();
            }
        }

        /**
         *  递归实现
         *      中序遍历
         * */
        public void infixOrder() {
            if(left != null) {
                left.infixOrder();
            }
            System.out.println(this);
            if(right != null) {
                right.infixOrder();
            }
        }
    }

    private Node root;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    /**
     *  添加结点
     * */
    public void add(Node node) {
        if(root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    /**
     *  查找结点
     * */
    public Node search(Node node) {
        if(root == null) {
            return null;
        }
        return root.search(node);
    }

    /**
     *  查找结点的父节点
     * */
    public Node getParnet(Node node) {
        if(root == null) {
            return null;
        }
        return root.getParnet(node);
    }

    /**
     *  递归实现
     *      删除结点
     *  TODO:
     *      删除比较复杂，需要考虑三种情况
     *        1.删除的结点是叶子结点
     *          1) 找到该结点的父节点parent和需要删除的结点target
     *          2) 判断该结点是父节点的left还是right
     *              2.1) 结点是父节点的left: parent.left = null;
     *              2.2) 结点是父节点的right: parent.right = null;
     *        2.删除只有一颗子树的结点
     *          1) 找到该结点的父节点parent和需要删除的结点target
     *          2) 判断该结点是父节点的left还是right
     *              target是父节点的left结点，那么target唯一的子树（不论左还是右）均比parent的value小，因此可以用target唯一的子树代替target位置
     *              target是父节点的right结点，那么target唯一的子树（不论左还是右）均比parent的value大，因此可以用target唯一的子树代替target位置
     *          3) 找到需要删除的结点target的唯一子树 child
     *          4) 判断唯一子树 child 是需要删除的结点target的左子树还是右子树
     *          5) parent.(left or right) = target.(left or right)
     *        3.删除有两颗子树的结点
     *          1) 找到该结点的父节点parent和需要删除的结点target
     *          2) 判断该结点是父节点的left还是right
     *              target是父节点的left结点，由于target结点存在两个子结点，因此直接使用target的左/右子节点替换target的位置，还需要判断target的左/右子节点存不存在子节点的问题
     *              因此，可以寻找target的左子树的最大值来替代target位置
     *              或者，寻找target的右子树的最小值来替代target位置
     *          3) target的右子树的最小值来替代target位置 or 寻找target的左子树的最大值来替代target位置
     * */
    public void delNode(Node node) {
        // 1. 找到该结点的父节点parent和需要删除的结点target
        Node target = search(node);
        Node parent = getParnet(node);
        if(target == null) {
            // 结点没有找到
            return;
        }
        Node vRoot = null;
        if(parent == null) {
            // 删除的是根节点，可以给根节点设置一个虚拟的父节点
            vRoot = new Node(0);
            vRoot.setLeft(root);
            parent = vRoot;
        }
        if(target.left == null && target.right ==null) {
            // 删除的结点是叶子结点
            if(parent.left == target) {
                parent.left = null;  // 目标结点是父节点的左子节点，删除叶子结点
            } else {
                parent.right = null;  // 目标结点是父节点的右子结点，删除叶子结点
            }
        } else if(target.left != null && target.right != null) {
            // 删除的结点存在两个子树
            // 寻找target右子树最小的结点，替换target位置
            Node minNode = target.right.getMinNode();
            Node minNodeParent = getParnet(minNode);
            if(minNodeParent.left == minNode) {
                minNodeParent.left = null;
            } else {
                minNodeParent.right = null;
            }
            minNode.left = target.left;
            minNode.right = target.right;
            if(parent.left == target) {
                // 删除的结点是其父节点的左子节点
                parent.left = minNode;
            } else {
                // 删除的结点是其父节点的右子节点
                parent.right = minNode;
            }
        } else {
            // 删除的结点存在一颗子树
            if(parent.left == target && target.left != null) {
                // 删除的结点是其父节点的左子节点，并且删除结点存在一颗左子树
                parent.left = target.left;  // 使用删除结点的左子树替换目标结点
            } else if(parent.right == target && target.left != null) {
                // 删除的结点是其父节点的右子节点，并且删除结点存在一颗左子树
                parent.right = target.left;  // 使用删除结点的左子树替换目标结点
            } else if(parent.left == target && target.right != null) {
                // 删除的结点是其父节点的左子节点，并且删除结点存在一颗右子树
                parent.left = target.right;  // 使用删除结点的右子树替换目标结点
            } else if(parent.right == target && target.right != null) {
                // 删除的结点是其父节点的右子节点，并且删除结点存在一颗右子树
                parent.right = target.right;  // 使用删除结点的右子树替换目标结点
            }
        }
        if(vRoot != null) {
            // 删除了root结点，需要更新root结点
            root = vRoot.left;
        }

    }
    /**
     *  中序遍历
     * */
    public void infixOrder() {
        if(root ==null) {
            System.out.println("空树");
            return;
        }
        root.infixOrder();
    }
}
