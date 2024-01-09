package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 * ClassName: SearchTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 10:04
 * @Version 1.0
 * Description:
 *       查找算法测试类
 */
public class SearchTest {


    @Test
    public void testSequenceSearch() {
        SequenceSearch sequenceSearch = new SequenceSearchProxy();

        Integer[] arr1 = {1, 9, 11, -1, 34, 89};
        sequenceSearch.search(arr1, 11);
        sequenceSearch.search(arr1, 89);
        sequenceSearch.search(arr1, 100);

     }


     @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearchProxy();


        Integer[] arr2 = {1, 8, 10, 1000, 1000, 1234};
        binarySearch.search(arr2, 1000);
        binarySearch.searchMulti(arr2, 1000);
        binarySearch.searchMulti(arr2, 10000);

    }

    @Test
    public void testInterpolationSearch() {
        InterpolationSearch interpolationSearch = new InterpolationSearchProxy();


        Integer[] arr2 = {1, 8, 10, 1000, 1000, 1234};
        interpolationSearch.search(arr2, 1000);
        interpolationSearch.searchMulti(arr2, 1000);
        interpolationSearch.searchMulti(arr2, 10000);
    }



    @Test
    public void testFibonacciSearch() {
        FibonacciSearch fibonacciSearch = new FibonacciSearchSearchProxy();


        Integer[] arr2 = {1, 8, 10, 1000, 1000, 1234};
        fibonacciSearch.search(arr2, 1000);
        fibonacciSearch.search(arr2, 1);
        fibonacciSearch.search(arr2, 8);
    }
}
