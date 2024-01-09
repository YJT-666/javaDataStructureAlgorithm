package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: BinarySearch
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 10:27
 * @Version 1.0
 * Description:
 *       二分法查找实现
 *       要求：待查找的数组是有序的，这里假定是升序排列的数组
 *       基本思路：
 *          1. 确定改数组当中中间的下标 mid=(left+right)/2
 *          2. 让需要查找的元素 target 与中间下标处的元素arr[mid]比较
 *              2.1 target > arr[mid] , 说明要查找的元素在 mid 的右边，因此递归向右查找
 *                  search(arr, mid+1, right);
 *              2.2 target < arr[mid] , 说明要查找的元素在 mid 的左边，因此递归向左查找
 *                  search(arr, left, mid-1);
 *              2.3 target = arr[mid] , 找到，返回下标，结束递归
 *          3. 如果递归完整个数组都没有找到，说明数组当中不存在整个元素,返回null，结束递归
 *              数组都没有找到 满足： left > right
 */
public class BinarySearch {


    /**
     *  二分法查找 实现
     *  在 [left,right] 范围内查找 target
     *  这种实现，在一个数组当中出现多个相同元素的情况下，返回的是第几个元素下标是不确定的
     *  要求
     *    数组arr有序（升序）
     *  TODO:
     *          1. 确定改数组当中中间的下标 mid=(left+right)/2
     *          2. 让需要查找的元素 target 与中间下标处的元素arr[mid]比较
     *              2.1 target > arr[mid] , 说明要查找的元素在 mid 的右边，因此递归向右查找
     *                  search(arr, mid+1, right);
     *              2.2 target < arr[mid] , 说明要查找的元素在 mid 的左边，因此递归向左查找
     *                  search(arr, left, mid-1);
     *              2.3 target = arr[mid] , 找到，返回下标，结束递归
     *          3. 如果递归完整个数组都没有找到，说明数组当中不存在整个元素,返回null，结束递归
     *              数组都没有找到 满足： left > right
     * */
    public Integer binarySearch(Integer[] arr, int left, int right, Integer target) {

        if(left > right) return null;   // 数组当中没有元素可供查找了，因此没有找到目标的元素

        int mid = (left+right)/2;
        if(target < arr[mid]) {
            // 向左递归查找
            return binarySearch(arr, left, mid-1, target);
        } else if(target > arr[mid]) {
            // 向右递归查找
            return binarySearch(arr, mid+1, right, target);
        } else {
            // 找到了
            return mid;
        }
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

        // 这种实现，在一个数组当中出现多个相同元素的情况下，返回的是第几个元素下标是不确定的
        // return binarySearch(arr, 0, arr.length-1, target);

        // 这种实现，在一个数组当中出现多个相同元素的情况下，返回的是最先出现目标元素的下标
        List<Integer> integers = new ArrayList<>();
        binarySearchMulti(arr, 0, arr.length-1, target, integers);
        Collections.sort(integers);
        if(integers != null && integers.size()>0) {
            return integers.get(0);
        }
        return null;
    }


    /**
     *  二分查找，有多个相同的数值时，将所有的数值度找到
     * */
    public List<Integer> searchMulti(Integer[] arr, Integer target) {
        List<Integer> integers = new ArrayList<>();
        binarySearchMulti(arr, 0, arr.length-1, target, integers);
        Collections.sort(integers);
        return integers;
    }

    /**
     *  二分查找，有多个相同的数值时，将所有的数值度找到
     * */
    private void binarySearchMulti(Integer[] arr, int left, int right, Integer target, List<Integer> integers) {
        if(left > right) return;   // 查找完毕，结束递归

        int mid = (left+right)/2;
        if(target.equals(arr[mid])) {
            // 找到一个结果，加入结果队列
            integers.add(mid);
        }
        // 向左递归查找
        binarySearchMulti(arr, left, mid-1, target, integers);
        // 向右递归查找
        binarySearchMulti(arr, mid+1, right, target, integers);
    }


}
class BinarySearchProxy extends BinarySearch {

    /**
     *  对 search 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public Integer search(Integer[] arr, Integer target) {
        System.out.println("-----------Binary Search-------------");
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
        System.out.println("-----------BinaryMulti Search-------------");
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