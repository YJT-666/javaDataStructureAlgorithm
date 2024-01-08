package com.jjt.dataStructure;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: ShellSort
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 19:38
 * @Version 1.0
 * Description:
 *      希尔排序的实现
 *          希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
 *          希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 *          尽量地把小的数往前调，大的数往后调，避免出现小的数在很后面导致的频繁移动元素
 *      基本思路：
 *          希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 *          随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 *
 */
public class ShellSort {


    /**
     *  希尔排序    时间复杂度O(n^2)   空间复杂度O(1)
     *  实测来看效果是优于插入排序的，速度提升还是非常明显的
     *  TODO
     *    分组  移位 （优）
     * */
    public void sort(Integer[] arr) {
        for(int gap = arr.length/2; gap > 0; gap /=2) {
            // 从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                Integer temp = arr[j];
                while (j-gap >=0 && temp < arr[j-gap]) {
                    //移动
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                // 当退出 while 后，就给temp找到合适的插入位置了
                if(j != i) {
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     *  希尔排序
     *  TODO
     *    分组  交换
     * */
    public void sort2(Integer[] arr) {

        int temp = 0;
        int cnt = 0;
        for(int gap = arr.length/2; gap >0 ; gap /=2){
            for(int i=gap; i<arr.length; i++) {
                // 遍历各组种所有的元素（共gap组, 每组 len/gap 个元素)，步长gap
                for (int j = i - gap; j >=0 ; j-= gap) {
                    // 组内的元素，大的往后移，像冒泡排序
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++cnt) + "轮=" + Arrays.toString(arr));
        }
    }
}


class ShellSortProxy extends ShellSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Shell Sort-------------");
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

        System.out.println("本次排序总共花费 " + interval+ "s");
        System.out.println("-----------------------------------");
    }
}