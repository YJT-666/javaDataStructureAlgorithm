package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: HeapSort2
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/10 16:00
 * @Version 1.0
 * Description:
 *           堆排序的第二种实现
 *           这种实现方式，相比第一种，大大减少了交换的次数，提高了效率
 */
public class HeapSort2 {

    /**
     *    完成将以 i 对应的非叶子结点的树调整成大顶堆
     *      调用这个方法时，需要 i 结点的左右子节点的子树已经是大顶堆了
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组当中的索引
     * @param length [0, length-1] 范围内的元素是有效的
     */
    public void adjustHeap(Integer arr[], int i, int length) {
        int temp = arr[i];  // 先取出当前元素值
        // 开始调整
        for (int k=i*2+1; k<length; k=k*2+1) {
            // 不断向左查找左子节点
            if(k+1 < length && arr[k] < arr[k+1]) {
                // 存在右子结点，并且右子结点的值大
                k++; // 指向右子结点
            }
            if(arr[k] > temp) {
                // 子节点大于父节点
                arr[i] = arr[k];  // 把较大结点的值赋值给父节点
                i = k;            // 发生了交换，i记录交换的目标位置
            } else {
                break;            // 已经满足父节点的值大于子节点
            }
        }
        // 找到合适的位置 i 将 temp的值插入
        arr[i] = temp;
    }


    public void heapSort(Integer[] arr) {
        // 1 需要将数组构建成一个大顶堆
        for(int i = arr.length/2 - 1; i >=0; i-=1) {
            // 从叶子结点的父节点开始，构建大顶堆
            adjustHeap(arr, i, arr.length);
        }

        // 2 交换大顶堆元素、调整大顶堆
        Integer temp; // 用于交换的临时变量
        for(int i= arr.length-1; i>=0; i--) {
            //将数组第一个元素，大顶堆最大的元素，与 arr[i] 交换
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 这样形成一个除了第一个结点不满足大顶堆的性质，而其子节点形成的堆满足大顶堆的性质的二叉树
            // 因此可以使用adjustHeap来对第一个结点进行调整，使其从新形成大顶堆
            adjustHeap(arr, 0, i);  // 长度已经是从 arr.length-1 开始，因此这里不需要-1
        }
    }

    /**
     *  排序算法调用入口
     * */
    public void sort(Integer arr[]) {
        heapSort(arr);
    }

}
class HeapSort2Proxy extends HeapSort2 {

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