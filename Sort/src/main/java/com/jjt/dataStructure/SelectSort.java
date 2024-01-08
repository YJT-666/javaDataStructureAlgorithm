package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: SelectSort
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 18:11
 * @Version 1.0
 * Description:
 *             选择排序实现
 *             基本思想
 *              第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 *              第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 *              第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 *              第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 *              第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 *              总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class SelectSort {



    /**
     * 选择排序   时间复杂度O(n^2) 空间复杂度O(1)   实际执行起来速度还是快于冒泡排序的
     * 输入：arr 是待排序的数组
     * TODO:
     *   1. 选择排序一共需要进行 数组大小-1轮排序
     *   2. 第i轮排序，需要找到剩余未排序数组当中最小的元素，与arr[i]进行交换
     * */

    public void sort(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // 寻找最小的元素
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            if(minIndex!=i) {
                Integer temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}

class SelectSortProxy extends SelectSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Select Sort-------------");
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
