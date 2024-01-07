package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: QuickSort
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 22:30
 * @Version 1.0
 * Description:
 *     快速排序法实现
 *       采用递归来实现快速排序
 *     基本思路：
 *       快速排序法是对冒泡排序法的一种改进；
 *          1.每一次排序选定一个数作为基准进行分组
 *            将比这个数小的数交换到这个数的左边；
 *            将比这个数大的数交换到这个数的右边；
 *          2.这个数左边的数长度大于1的话，继续执行步骤1
 *            这个数左边的数长度等于1的话，天然是有序的，终止递归
 *          3.这个数右边的数长度大于1的话，继续执行步骤1
 *            这个数右边的数长度等于1的话，天然是有序的，终止递归
 */
public class QuickSort {

    /**
     * 快速排序法实现
     *      arr 是参与排序的数组，对数组[start, end] 范围的元素进行快速排序
     * TODO:
     *      选定基准元素位数组当中的中间的元素  pivot = arr[(start+end)/2];
     *      采用双指针，left、right分别从start 和 end 向 pivot 移动
     *          left寻找比 pivot 大的元素
     *          right寻找比 pivot 小的元素
     *          找到后进行交换
     *
     *      - - - pivot + - +
     *              l     r
     *      - - -   - +  pivot +
     *
     *                l   r
     *      - - -   - +  pivot +
     *                l      r
     *      - - -   - pivot  + +
     *
     *
     *
     * */
    public void quickSort(Integer[] arr, int start, int end) {
        Integer pivot = arr[(start+end)/2];
        int left = start;
        int right = end;

        Integer temp = 0;
        while (left < right) {

            // 在pivot的左边，找一个大于或等于pivot值的元素
            while (arr[left] < pivot) {
                left += 1;
            }
            // 在pivot的右边，找一个小于或等于pivot值的元素
            while (arr[right] > pivot) {
                right -= 1;
            }

            if(left >= right) {
                // baseIndex的左边的值已经全部小于baseIndex
                // baseIndex的右边的值已经全部大于baseIndex
                break;
            }
            // 交换
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            /**
             *  下面两句，避免当 arr[left] == pivot 或者 arr[right] == pivot时,
             *  进不去最上面两个可以使得  left++; 和 right--;的循环，从而造成死循环（无限交换）
             * */
            // 如果交换完以后，发现arr[left] == pivot
            // 说明 r 指向了一个已经是比pivot大的数了，r--, 进行前移动
            if(arr[left] == pivot) {
                right -= 1;
            }
            // 如果交换完以后，发现arr[right] == pivot
            // 说明 l 指向了一个已经是比pivot小于的数了，l++, 进行后移动
            if(arr[right] == pivot) {
                left += 1;
            }
        }

        // 如果 left == right， 必须执行，否则会出现栈溢出
        if(left == right) {
            left += 1;
            right -= 1;
        }
        // 向左递归
        if(start < right) {
            // 左边存在2个以上的元素
            quickSort(arr, start, right);
        }
        // 向右递归
        if(end > left) {
            // 右边存在2个以上的元素
            quickSort(arr, left, end);
        }
    }

    public static void quickSort2(Integer[] arr,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        Integer temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort2(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort2(arr, l, right);
        }


    }


    /**
     *   封装调用快速排序法
     * */
    public void sort(Integer[] arr){
        quickSort(arr, 0, arr.length-1);
    }
}

class QuickSortProxy extends QuickSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Quick Sort-------------");
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




































