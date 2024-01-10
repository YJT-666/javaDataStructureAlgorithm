package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * ClassName: SortTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 16:18
 * @Version 1.0
 * Description:
 *    排序算法测试类
 */
public class SortTest {

    @Test
    public void testBubbleSort() {

        BubbleSort bubbleSort = new BubbleSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        bubbleSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        bubbleSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        bubbleSort.sort(arr3);

    }

    @Test
    public void testSelectSort() {

        SelectSort selectSort = new SelectSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        selectSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        selectSort.sort(arr2);

        Integer[] arr3 = new Integer[80000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*80000);
        }
        selectSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        selectSort.sort(arr4);

    }

    @Test
    public void testInsertSort() {

        InsertSort insertSort = new InsertSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        insertSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        insertSort.sort(arr2);

        Integer[] arr3 = new Integer[80000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*80000);
        }
        insertSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        insertSort.sort(arr4);

    }

    @Test
    public void testShellSort() {

        ShellSort shellSort = new ShellSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        shellSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        shellSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        shellSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        shellSort.sort(arr4);

    }
    @Test
    public void testQuickSort() {

        QuickSort quickSort = new QuickSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        quickSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        quickSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        quickSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        quickSort.sort(arr4);

        Integer[] arr5 = new Integer[]{-9, 78, 0, 23, -567, 70};
        quickSort.sort(arr5);
    }

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        mergeSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        mergeSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        mergeSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        mergeSort.sort(arr4);

        Integer[] arr5 = new Integer[]{-9, 78, 0, 23, -567, 70};
        mergeSort.sort(arr5);
    }


    @Test
    public void testRadixSort() {
        RadixSort radixSort = new RadixSortProxy();

//        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};  // 基排序不能用于负数的排序
//        radixSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        radixSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];    // 数据量过大会发生内存溢出  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        radixSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        radixSort.sort(arr4);

        Integer[] arr5 = new Integer[]{53, 3, 542, 748, 14, 214};
        radixSort.sort(arr5);

    }

    @Test
    public void testHeapSort() {
        HeapSort heapSort = new HeapSortProxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        heapSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        heapSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        heapSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        heapSort.sort(arr4);

        Integer[] arr5 = new Integer[]{-9, 78, 0, 23, -567, 70};
        heapSort.sort(arr5);
    }

    @Test
    public void testHeapSort2() {
        HeapSort2 heapSort = new HeapSort2Proxy();

        Integer[] arr1 = new Integer[]{3, 9, -1, 10, -2};
        heapSort.sort(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5};
        heapSort.sort(arr2);

        Integer[] arr3 = new Integer[8000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int)(Math.random()*arr3.length);
        }
        heapSort.sort(arr3);

        Integer[] arr4 = new Integer[]{101, 34, 119, 1};
        heapSort.sort(arr4);

        Integer[] arr5 = new Integer[]{-9, 78, 0, 23, -567, 70};
        heapSort.sort(arr5);
    }
}










