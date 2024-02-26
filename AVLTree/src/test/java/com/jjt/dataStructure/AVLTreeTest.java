package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: AVLTreeTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/16 16:30
 * @Version 1.0
 * Description:
 */
public class AVLTreeTest {

    @Test
    public void test01() {
        AVLTree avlTree = new AVLTree();
        Integer[] nums = new Integer[]{4,3,6,5,7,8};
        for (int i = 0; i < nums.length; i++) {
            avlTree.add(new AVLTree.Node(nums[i]));
        }
        int treeHeight = avlTree.getHeight();
        System.out.println("treeHeight = " + treeHeight);
        avlTree.infixOrder();
    }

    @Test
    public void test02() {
        AVLTree avlTree = new AVLTree();
        Integer[] nums = new Integer[]{10,12,8,9,7,6};
        for (int i = 0; i < nums.length; i++) {
            avlTree.add(new AVLTree.Node(nums[i]));
        }
        int treeHeight = avlTree.getHeight();
        System.out.println("treeHeight = " + treeHeight);
        avlTree.infixOrder();
    }


    @Test
    public void test03() {
        AVLTree avlTree = new AVLTree();
        Integer[] nums = new Integer[]{34, 23,15,98,115,28,107};
        for (int i = 0; i < nums.length; i++) {
            avlTree.add(new AVLTree.Node(nums[i]));
        }
        int treeHeight = avlTree.getHeight();
        System.out.println("treeHeight = " + treeHeight);
        avlTree.infixOrder();
    }
}
