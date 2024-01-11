package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: HuffmanTreeTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/11 10:37
 * @Version 1.0
 * Description:
 */
public class HuffmanTreeTest {

    @Test
    public void test01() {
        Integer[] arr1 = new Integer[]{13,7,8,3,29,6,1};
        HuffmanTree huffmanTree = new HuffmanTree(arr1);
        huffmanTree.preOrder();
    }
}
