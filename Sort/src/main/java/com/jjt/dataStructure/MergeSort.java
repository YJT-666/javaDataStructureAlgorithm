package com.jjt.dataStructure;

import java.lang.module.ModuleDescriptor;
import java.util.Arrays;

/**
 * ClassName: MergeSort
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/8 18:00
 * @Version 1.0
 * Description:
 *         归并排序实现
 *
 *         基本思路：
 *              利用归并的思想实现的排序方法，
 *              该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 *              而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)
 */
public class MergeSort {


    /**
     *  归并排序  合并过程
     *    TODO:
     *      归并排序就是不断合成两个有序的子序列，形成一个新的子序列的过程
     * @param arr   需要进行排序的数组
     * @param left  [left, mid] 是第一个有序的子序列
     * @param mid
     * @param right  [mid+1, right] 是第二个有序的子序列
     * @param temp  临时数组，用于临时存放两个有序子序列合并的结果
     */
    public void merge(Integer[] arr, int left, int mid, int right, Integer[] temp) {
        int i = left;     // 用于遍历 [left, mid] 子序列
        int j = mid +1;   // 用于遍历 [mid+1, right] 子序列
        int t = 0;        // 记录跟踪 temp 数组当中的元素
        // 把小的值放入 temp 数组当中
        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[t++] = new Integer(arr[i++]);
            } else {
                temp[t++] = new Integer(arr[j++]);
            }
        }
        while (i <= mid) {
            temp[t++] = new Integer(arr[i++]);
        }

        while (j <= right) {
            temp[t++] = new Integer(arr[j++]);
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    /**
     *  归并排序  分+合
     *    TODO:
     *      归并排序就是不断合成两个有序的子序列，形成一个新的子序列的过程
     * @param arr   需要进行排序的数组
     * @param left  对 [left, right] 之间的数据进行先分后合的分治排序
     * @param right
     * @param temp  临时数组，用于临时存放两个有序子序列合并的结果
     *              归并排序需要额外的存储空间
     */
    public void mergeSort(Integer[] arr, int left, int right, Integer[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;   // 中间索引
            // 向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid+1, right, temp);
            // 到合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     *  归并排序调用此方法
     *      arr 是要进行排序的数组
     * */
    public void sort(Integer[] arr) {
        mergeSort(arr, 0, arr.length - 1, new Integer[arr.length]);
    }
}


class MergeSortProxy extends MergeSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Merge Sort-------------");
        if(arr.length < 10) {
            System.out.println("before sort:");
            System.out.println(Arrays.toString(arr));
        }
        long s1 = System.currentTimeMillis();
        super.sort(arr);
        long s2 = System.currentTimeMillis();
        double interval =  (s2-s1)/1000.0;

        if(arr.length < 10) {
            System.out.println("After sort:");
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("共"+arr.length+"个元素"+ ",本次排序总共花费 " + interval+ "s");
        System.out.println("-----------------------------------");
    }
}