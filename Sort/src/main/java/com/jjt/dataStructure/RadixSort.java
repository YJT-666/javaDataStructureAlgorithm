package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: RadixSort
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/8 19:33
 * @Version 1.0
 * Description:
 *                基数排序（桶排序）实现
 *
 *                注意：基数排序并不能用于有负数的排序
 */
public class RadixSort {


    /**
     *   基数排序
     *      arr 是要进行排序的数组
     *      bin 是要表示要取的位
     *          1    表示个位
     *          2    表示十位
     *          3    表示百位
     *   TODO:
     *      基排序是一个以空间换时间的经典算法
     * */
    public void radixSort(Integer[] arr) {

        // 定义一个二维数组，表示10个桶（数字0~9），每一个桶就是一个一维数组
        Integer[][] bucket = new Integer[10][arr.length];
        int bin = 0;
        while (true) {
            // 跟踪每个桶内存放的元素指针
            int[] bucketElemectCnts = new int[10];
            int binDiv = (int)Math.pow(10, bin++);
            // 把元素放到对应的桶中
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / binDiv % 10;
                bucket[digit][bucketElemectCnts[digit]] = new Integer(arr[i]);
                bucketElemectCnts[digit]++;
            }
            // 重新取出
            int index=0;
            for (int i = 0; i < 10; i++) {
                if(bucketElemectCnts[i] > 0) {
                    // 桶中有数据
                    for (int j = 0; j < bucketElemectCnts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
            }
            if(bucketElemectCnts[0] == arr.length) {
                break;
            }
        }

    }


    /**
     *  桶排序调用此方法
     *      arr 是要进行排序的数组
     * */
    public void sort(Integer[] arr) {
        radixSort(arr);
    }

}

class RadixSortProxy extends RadixSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Radix Sort-------------");
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