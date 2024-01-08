package com.jjt.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: BubbleSort
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 16:00
 * @Version 1.0
 * Description:
 *     实现冒泡排序算法    交换排序
 *     冒泡排序（Bubble Sorting）的基本思想是：通过对待
 *     排序序列从前向后（从下标较小的元素开始）,依次比较
 *     相邻元素的值，若发现逆序则交换，使值较大
 *     的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
 *     向上冒。
 */
public class BubbleSort {




    /**
     *   冒泡排序    时间复杂度 O(n^2)  空间复杂度O(1)
     *   输入需要进行排序的数组
     *   TODO:
     *      冒泡排序 n 个数据
     *      1. 一共需要进行 n-1 次大的循环
     *         每一次大循环都会获得未排序元素当中的最大的元素
     *      2. 每一趟会找到一个有序的元素，因此每一趟需要进行的
     *         小循环次数会减少
     *      3. 优化：如果发现某一次小循环遍历的过程当中没有发生元素
     *         交换，说明数组已经是有序的了，可以提前结束排序
     * */
    public void sort(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // 大循环控制当前是寻找第几大的元素
            // 下面 -i 的含义是，第 i 趟排序，不用考虑已经排序好的 i 个数据
            boolean hasExchanged = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    // 逆序交换
                    Integer temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    hasExchanged = true;
                }
            }
            // 如果某趟排序没有发生元素交换，说明数组已经是有序了 可以提前中缀排序过程了
            if(!hasExchanged) {
                break;
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
}




class BubbleSortProxy extends BubbleSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Bubble Sort-------------");
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