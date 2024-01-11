package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: HuffmanTree
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/11 10:16
 * @Version 1.0
 * Description:
 *              哈夫曼树
 *              > 赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近
 */
public class HuffmanTree {


    /**
     *   结点类
     *   为了让 Node 对象支持排序 Collections 工具类的 集合排序
     *   需要实现 Comparable接口
     * */
    public class Node implements Comparable<Node>{
        private Integer value;  // 结点的权值
        private Node left;      // 指向左子节点
        private Node right;     // 指向右子节点

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;  // 升序排列
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

        /**
         *  前序遍历
         * */
        public void preOrder() {
            System.out.println(this);
            if(left != null) {
                this.left.preOrder();
            }
            if(right != null) {
                this.right.preOrder();
            }
        }
    }
    private Node root;  // 哈夫曼树的根节点

    /**
     * 创建哈夫曼树
     * @param arr 包含所有结点的权值数组
     */
    public HuffmanTree(Integer[] arr) {
        create(arr);
    }

    /**
     * 创建哈夫曼树
     * 基本思路
     * TODO:
     *  1. 将每一个数据构建成的二叉树结点node，放入到结点集合nodes当中
     *  2. 根据结点的权值对所有的结点进行升序排序
     *  3. 取出根节点权值最小的两颗二叉树
     *  4. 组成一颗新的二叉树，该新的二叉树的根节点权值是前面两颗二叉树根节点权值之和
     *  5. 将这颗新的二叉树的根节点放入到结点集合nodes当中，重复步骤2~5，直到所有的数据都被处理，这样就形成了一颗新的二叉树
     *
     * @param arr 包含所有结点的权值数组
     */
    public void create(Integer[] arr) {
        if(arr == null || arr.length == 0) {
            root = null;
            return;
        }
        // 1 将 arr 每一个元素构成一个Node对象，并加入ArrayList当中
        ArrayList<Node> nodes = new ArrayList<>();   // 保存Huffman树的结点
        for (Integer value:
                arr
             ) {
            nodes.add(new Node(value));
        }
        Node node0;
        Node node1;
        Node node2;
        while (nodes.size() > 1) {
            // 2 对 nodes 集合进行升序排列
            Collections.sort(nodes);
            // 3 取出根节点权值最小的两颗二叉树
            node1 = nodes.get(0);
            node2 = nodes.get(1);
            nodes.remove(node1);
            nodes.remove(node2);
            // 4 组成一颗新的二叉树，该新的二叉树的根节点权值是前面两颗二叉树根节点权值之和
            node0 = new Node(node1.getValue() + node2.getValue());
            if(node1.compareTo(node2) > 0) {
                // node1大放右边
                node0.setRight(node1);
                node0.setLeft(node2);
            } else {
                node0.setLeft(node1);
                node0.setRight(node2);
            }
            // 5 将这颗新的二叉树的根节点放入到结点集合nodes当中
            nodes.add(node0);
        }
        root = nodes.get(0);   // 赋值根节点
    }
    /**
     *  前序遍历 huffman树
     * */
    public void preOrder() {
        System.out.println("前序遍历:");
        if(root != null) {
            root.preOrder();
        }
        System.out.println("-------------------------------------");
    }
}
