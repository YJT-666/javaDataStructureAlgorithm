package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: FibonacciSearch
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 14:22
 * @Version 1.0
 * Description:
 *         使用 Fibnacci 法（黄金分割比）查找
 *         基本思路和二分查找的思路一样，区别在于 mid的求解
 *         在二分查找当中 mid = left + 1/2(right-left)
 *         在Fibnacci 法查找当中 mid = low + F(k-1)-1
 *
 *         任然需要查找的数组是有序的
 *         关于效率方面， 我觉得它更 “艺术”
 */
public class FibonacciSearch {


    /**
     *  获取Fibnacci 数列
     *    要求 n >= 2
     * */
    
    public ArrayList<Integer> fib(int n) {
        ArrayList<Integer> fibList = new ArrayList<>();
        fibList.add(1);   // 0 -> 1
        fibList.add(1);   // 1 -> 1
        for (int i = 2; i <= n; i++) {
            fibList.add(fibList.get(i-1) + fibList.get(i-2));
        }
        return fibList;
    }

    /**
     *   斐波那契查找算法
     *   使用非递归的方式
     *     arr 是要查找的数组
     *     target 是要查找的目标值
     * */
    public Integer fibSearch(Integer[] arr, Integer target) {

        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0;

        ArrayList<Integer> fibList = fib(20);   // 获取斐波那契数列

        // 获取斐波那契数列分割数值的下标
        while (high > fibList.get(k) - 1) {
            k++;
            if(k>20) {
                fibList = fib(2*k);
            }
        }
        // 因为 f[k] 的值可能大于 arr 的长度，因此需要使用Arrays类，构造一个新的数组，并指向arr[]
        // 不足的部分，使用0填充
        Integer[] temp = Arrays.copyOf(arr, fibList.get(k));
        // 对新的数组，不足的部分，使用arr[high]填充
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = new Integer(arr[high]);
        }

        // 使用 while 循环处理，找到target
        while (low <= high) {
            mid = low + fibList.get(k-1)-1;
            if(target < temp[mid]) {
                // 向数组前面查找
                high = mid-1;
                // 1. 全部的元素 = 前面的元素 + 后边的元素
                // 2. f[k]-1 = f[k-1]-1 + f[k-2]-1 + 1
                // 前面有 f[k-1]-1 个元素，往前查找就是整个查找元素的长度变成了 f[k-1]-1个。
                // 有 f[k-1]-1 = f[k-2]-1 + f[k-3]-1 + 1
                k--;
            } else if(target > temp[mid]) {
                // 向数组后面查找
                low = mid + 1;
                k -= 2;
                // k-2 是因为数组后半部分的长度为 f[k-2]-1
            } else {
                // 找到了
                return mid>arr.length-1 ? arr.length-1:mid;  // 保证返回的位置不是我们扩展数组扩展出的元素位置
            }
        }
        // 执行到这里，说明没有找到
        return null;
    }


    /**
     *  查找调用此方法
     *  在数组  arr  当中查找 target 元素
     *  返回 target  元素在 arr 数组的下标
     *  未找到返回 null
     *
     *  数组 arr  要求有序（升序）
     * */
    public Integer search(Integer[] arr, Integer target) {
        return fibSearch(arr, target);
    }
}


class FibonacciSearchSearchProxy extends FibonacciSearch {

    /**
     * 对 search 方法进行代理
     * 统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     */
    @Override
    public Integer search(Integer[] arr, Integer target) {
        System.out.println("-----------Fibonacci Search-------------");
        if (arr.length < 10) {
            System.out.println("before Search:");
            System.out.println(Arrays.toString(arr));
        }
        long s1 = System.currentTimeMillis();
        Integer res = super.search(arr, target);
        long s2 = System.currentTimeMillis();
        double interval = (s2 - s1) / 1000.0;
        System.out.println("在数组当中查找元素【" + target + "】的下标结果为: " + res);
        System.out.println("共" + arr.length + "个元素" + ",本次查找总共花费 " + interval + "s");
        System.out.println("-----------------------------------------------------");

        return res;
    }

}