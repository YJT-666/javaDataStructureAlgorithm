package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: HeapSort
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/10 14:54
 * @Version 1.0
 * Description:
 *               堆排序
 *
 *               基本思路：
 *                  把一个待排序的数组看成一个顺序存储的二叉树，对数组下标为n的元素，有如下性质：
 *                  > 左子节点在数组当中的下标为  2n+1
 *                  > 右子节点在数组当中的下标为  2n+2
 *                  > 父节点在数组当中的下标索引为 (n-1)/2  【整数除法】
 *               堆排序基本过程：
 *                  1.将这个待排序的数组进行建堆操作，形成一个大顶堆
 *                  2.将第一个元素（堆顶元素）与数组最后一个元素交换
 *                  3.将最后一个元素剔除后形成新的数组，重复步骤1-3，直到数组当中只有一个元素为止
 *
 *               建堆（大顶堆）：
 *                  从后往前遍历数组元素i, 得到其父节点 p=(i-1)/2, 然后对其父结点执行维护堆性质的操作
 *               维护堆性质：
 *                  判断父节点与左右子结点的大小关系（父节点的值大于子节点的值）
 *                      父节大于左右子节点，表示当前结点已经满足堆性质
 *                      父节点与较大的字节点进行交换，使其满足堆性质
 */
public class HeapSort {


    /**
     * 维护堆的性质
     *
     * @param arr    存储数据的数组
     * @param length 建堆的数组长度，对arr[0, length-1]范围内的数据执行建堆
     * @param i      待维护堆性质的结点（父节点）
     * @param value  最原先的结点的值，用于比较，寻找合适的插入位置
     * @return 修改过的位置 int   返回的是一个适合插入 最原先结点值的位置
     */
    public int heapify(Integer[] arr, int length, int i, Integer value) {
        if(i >= length) {
            throw  new RuntimeException("待维护堆关系的元素，不在数组范围内");
        }
        Integer maxValue = value;
        int largestIndex = i; // 记录父、子结点当中值最大的索引
        int leftSon = 2*i+1;
        int rightSon = 2*i+2;
        if(leftSon < length && arr[leftSon] > maxValue) {
            // 左子节大
            largestIndex = leftSon;
            maxValue = arr[leftSon];
        }
        if(rightSon < length && arr[rightSon] > maxValue) {
            // 右子节点大
            largestIndex = rightSon;
        }
        if(largestIndex != i) {
            // 最大的结点不是父节点，执行 将最大元素赋值上去
            arr[i] = arr[largestIndex];
            return heapify(arr, length, largestIndex, value); // 返回记录了交换上去的元素位置
        }
        return largestIndex;
    }

    /**
     * 建堆，建立大顶堆
     *
     * 对 arr[0, length-1] 范围的元素，建立大顶堆
     *
     * @param arr    存储数据的数组
     * @param length 建堆的数据长度
     */
    public void buildHeap(Integer arr[], int length) {
        // 从第一个非叶子结点开始，后往前遍历数组元素结点
        int p = 0;
        for (int i = length/2-1; i >= 0; i--) {
            Integer temp = arr[i];            // 记录当前父节点的值
            int k = heapify(arr, length, i, temp);  // 对其父节点进行建堆操作
            if(i != k ) {
                // 发生了交换，父节点的值放大合适位置
                arr[k] = temp;
            }
        }
    }

    /**
     *    完成将以 i 对应的非叶子结点的树调整成大顶堆
     *      调用这个方法时，需要 i 结点的左右子节点的子树已经是大顶堆了
     * @param arr    待调整的数组
     * @param length [0, length-1] 范围内的元素是有效的
     * @param i      表示非叶子结点在数组当中的索引
     */
    public void adjustHeap(Integer arr[], int length, int i) {
        Integer temp = arr[i];  // 记录当前父节点的值
        int k = heapify(arr, length, i, temp);  // 对其父节点进行建堆操作
        if(i != k ) {
            // 发生了交换，父节点的值放到合适位置
            arr[k] = temp;
        }
    }


    /**
     *  堆排序
     *    1.将这个待排序的数组进行建堆操作，形成一个大顶堆
     *    2.将第一个元素（堆顶元素）与数组最后一个元素交换
     *    3.将最后一个元素剔除后形成新的数组，重复步骤1-3，直到数组当中只有一个元素为止
     * */
    public void heapSort(Integer[] arr) {
        int length = arr.length;

        // 1 建堆
        buildHeap(arr, length);

        //  2 交换大顶堆元素、调整大顶堆
        Integer temp;  // 临时变量，用于交换
        while (true) {
            // 执行交换
            temp = arr[0];
            arr[0] = arr[length-1];
            arr[length-1] = temp;
            length--;
            if(length < 2) break;
            // 调整堆
            adjustHeap(arr, length, 0);
        }
    }

    /**
     *  排序算法调用入口
     * */
    public void sort(Integer arr[]) {
        heapSort(arr);
    }
}


class HeapSortProxy extends HeapSort {

    /**
     *  对 sort 方法进行代理
     *  统计排序花费的时间，并且当数组大小小于10，打印排序前后的数组
     * */
    @Override
    public void sort(Integer[] arr) {
        System.out.println("-----------Heap Sort-------------");
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