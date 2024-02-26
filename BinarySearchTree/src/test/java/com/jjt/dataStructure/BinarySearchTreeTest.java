package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: BinarySearchTreeTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/16 14:37
 * @Version 1.0
 * Description:
 */
public class BinarySearchTreeTest {


    @Test
    public void test01() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Integer[] nums=new Integer[]{7,3,10,12,5,1,9,2,11};
        for (int i = 0; i < nums.length; i++) {
            binarySearchTree.add(new BinarySearchTree.Node(nums[i]));
        }
        binarySearchTree.infixOrder();

        System.out.println("-------------------------------------------");
        System.out.println("测试删除");
        binarySearchTree.delNode(new BinarySearchTree.Node(7));
        binarySearchTree.infixOrder();
    }
}
