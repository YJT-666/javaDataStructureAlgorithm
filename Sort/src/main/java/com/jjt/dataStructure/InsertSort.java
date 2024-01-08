package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: InsertSort
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 18:34
 * @Version 1.0
 * Description:
 *          插入排序
 *          基本思想：
 *               把n个待排序的元素看成为一个有序表和一个无序表，开
 *               始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 *               排序过程中每次从无序表中取出第一个元素，
 *               把它的排序码依次与有序表元素的排序码进行比较，
 *               将它插入到有序表中的适当位置，使之成为新的有序表。
 */
public class InsertSort {


    /**
     * 插入排序  时间复杂度O(n^2)  空间复杂度O(1)
     * TODO
     * */
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer InsertValue = arr[i];
            int j = i-1;
            while (j>=0 && InsertValue < arr[j]) {
                arr[j+1] = arr[j];    // 往后移腾位置
                j--;
            }
            if(j != i-1) {
                // 找到要插入的位置，执行插入
                arr[j+1] = InsertValue;
            }
        }
    }

    /**
     * 插入排序
     * TODO
     *   这种实现有三个循环
     * */
    public void sort2(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    // 那么需要将 arr[i] 插入到 arr[j] 的前面
                    // 1. 保存arr[i]的值到temp
                    Integer temp = arr[i];
                    // 2. 将 [arr[j], arr[i]) 依次后移一个位置
                    for (int k = i; k >j ; k--) {
                        arr[k] = arr[k-1];
                    }
                    // 3. 将temp插入到arr[j]
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
}


class InsertSortProxy extends InsertSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Insert Sort-------------");
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