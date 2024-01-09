package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: InterpolationSearch
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 13:35
 * @Version 1.0
 * Description:
 *    插值查找算法实现
 *
 *      插值查找的基本思路和二分查找的思路一样，区别在于 mid的求解
 *      在二分查找当中 mid = left + 1/2(right-left)
 *      在插值查找当中 mid = left + (target-arr[left])/(arr[left]-arr[right]) (right-left)
 *      这样可以快速将 mid 定位到目标值附件，加快查找速度
 *
 *      关键字分布比较均匀的情况下，插值插值比二分插值的速度更快
 *      分布不均匀的情况下，插值查找的速度不一定快于二分查找
 */
public class InterpolationSearch {


    /**
     *   插值插值算法
     *
     * @param arr
     * @param left
     * @param right
     * @param target    目标值
     * @param indexList  保存找到目标元素在 arr[left, right] 数组当中的索引
     */
    public void interpSearch(Integer[] arr, int left, int right, Integer target, List<Integer> indexList) {
        if(left > right || target > arr[right] || target < arr[left]) {
            return;  // 查找完毕，或者要查找的数据不在查找的范围内
        }

        int mid = (left + right) / 2;
        int distance = arr[right] - arr[left] == 0 ? 1 : arr[right] - arr[left];
        if(distance != 0) {
            mid = left + (target - arr[left]) / distance * (right-left);
        }

        if(arr[mid].equals(target)) {
            // 找到一个目标值
            indexList.add(mid);
        }
        // 向左递归查找
        interpSearch(arr, left, mid-1, target, indexList);
        // 向右递归查找
        interpSearch(arr, mid +1 , right, target, indexList);
    }

    /**
     *  查找调用此方法
     *  二分法查找  时间复杂度为 O(logn)
     *
     *  在数组  arr  当中查找 target 元素
     *  返回 target  元素在 arr 数组的下标
     *  未找到返回 null
     *
     *  数组 arr  要求有序（升序）
     * */
    public Integer search(Integer[] arr, Integer target) {
        // 这种实现，在一个数组当中出现多个相同元素的情况下，返回的是最先出现目标元素的下标
        List<Integer> indexList = new ArrayList<>();
        interpSearch(arr, 0, arr.length-1, target, indexList);
        Collections.sort(indexList);
        if(indexList != null && indexList.size()>0) {
            return indexList.get(0);
        }
        return null;
    }


    /**
     *  二分查找，有多个相同的数值时，将所有的数值度找到
     * */
    public List<Integer> searchMulti(Integer[] arr, Integer target) {
        List<Integer> indexList = new ArrayList<>();
        interpSearch(arr, 0, arr.length-1, target, indexList);
        Collections.sort(indexList);
        return indexList;
    }
}


class InterpolationSearchProxy extends InterpolationSearch {

    /**
     *  对 search 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public Integer search(Integer[] arr, Integer target) {
        System.out.println("-----------Interpolation Search-------------");
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


    /**
     *  对 searchMulti 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public List<Integer> searchMulti(Integer[] arr, Integer target) {
        System.out.println("-----------InterpolationSearchMulti Search-------------");
        if(arr.length < 10) {
            System.out.println("before Search:");
            System.out.println(Arrays.toString(arr));
        }
        long s1 = System.currentTimeMillis();
        List<Integer> integers = super.searchMulti(arr, target);
        long s2 = System.currentTimeMillis();
        double interval =  (s2-s1)/1000.0;
        System.out.println("在数组当中查找元素【" + target + "】的下标结果为: " + integers.toString());
        System.out.println("共"+arr.length+"个元素"+ ",本次查找总共花费 " + interval+ "s");
        System.out.println("-----------------------------------------------------");

        return integers;
    }
}