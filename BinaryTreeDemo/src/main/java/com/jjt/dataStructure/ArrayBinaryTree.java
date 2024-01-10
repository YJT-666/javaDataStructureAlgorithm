package com.jjt.dataStructure;

/**
 * ClassName: ArrayBinaryTree
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/10 10:35
 * @Version 1.0
 * Description:
 *             以数组的方式存储
 *             实现顺序存储二叉树
 *
 *             顺序存储二叉树有以下特点:
 *               1. 顺序存储二叉树只考虑完全二叉树
 *               2. 第 n 个元素的左子节点为 2n+1
 *               3. 第 n 个元素的右子节点为 2n+2
 *               4. 第 n 个元素的父节点为(n-1)/2
 *             n 表示二叉树当中的第几个元素，从 0 开始编号
 *
 */
public class ArrayBinaryTree {
    private Integer[] arr;   // 存储数据的数组

    public ArrayBinaryTree() {
        this(null);
    }

    public ArrayBinaryTree(Integer[] arr) {
        this.arr = arr;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    /**
     *  顺序存储二叉树的前序遍历
     * */
    public void preOrder() {
        // 数组为空，或者arr.length == 0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        this.preOrder(0);
        System.out.println();
    }

    /**
     *  顺序存储二叉树的前序遍历
     *
     *  n 是数组的下标，同时也表示是顺序存储二叉树当中的第 n 个元素
     **/
    private void preOrder(int n) {
        // 输出当前节点
        System.out.print(arr[n] + " ");
        if ( 2*n+1 < arr.length) {
            // 向左递归遍历
            preOrder(2*n+1);
        }
        if( 2*n+2 < arr.length) {
            // 向右递归遍历
            preOrder(2*n+2);
        }
    }
}
