package com.jjt.dataStructure;

import java.net.Inet4Address;
import java.util.Arrays;

/**
 * ClassName: SequenceSearch
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 10:05
 * @Version 1.0
 * Description:
 *     线性查找
 *
 *       数组可以有序，也可以无序
 *
 *     基本思路：
 *        循环遍历数组当中的每一个元素，然后进行比较，获得数组当中于目标相等的元素位置
 */
public class SequenceSearch {


    /**
     *  线性查找  时间复杂度为 O(n)
     *
     *  在数组  arr  当中查找 target 元素
     *  返回 target 元素在 arr 数组的下标
     *  未找到返回 null
     *
     *  数组 arr  不要求有序
     * */
    public Integer search(Integer[] arr, Integer target) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target)) return i;
        }

        return null;
    }
}


class SequenceSearchProxy extends SequenceSearch {

    /**
     *  对 search 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public Integer search(Integer[] arr, Integer target) {
        System.out.println("-----------Sequence Search-------------");
        if(arr.length < 10) {
            System.out.println("before Search:");
            System.out.println(Arrays.toString(arr));
        }
        long s1 = System.currentTimeMillis();
        Integer res = super.search(arr, target);
        long s2 = System.currentTimeMillis();
        double interval =  (s2-s1)/1000.0;
        System.out.println("在数组当中查找元素【" + target + "】的下标结果为: " + res);
        System.out.println("共"+arr.length+"个元素"+ ",本次查找总共花费 " + interval+ "s");
        System.out.println("-----------------------------------------------------");

        return res;
    }
}