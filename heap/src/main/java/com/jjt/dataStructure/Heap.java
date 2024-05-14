package com.jjt.dataStructure;

import java.util.Properties;

/**
 * ClassName: Heap
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/5/14 10:39
 * @Version 1.0
 * Description:
 */
public class Heap {

    /**
     *   堆
     *      大顶堆(小顶堆）满足父节点的值都大于(小于）其子节点的值
     *      堆的插入和删除数据的效率较高，时间复杂度为 o(logn)
     *   堆的存储
     *      为了方便存储和索引，堆通常使用完全二叉树来进行表示
     *      完全二叉树可以使用数组来进行存储，也方便索引，若根节点的索引为 0 的化
     *      那么对于树当中任意而结点 i , 左子节点为 2i+1 , 右子节点的索引为 2i+2
     *
     *   堆的操作，以大顶堆为例
     *      插入元素  自底向上：
     *          1. 将要插入的元素，放到最后
     *          2. 将其与其父节点比较，如果比父节点元素的值大，则交换它们的位置，直到无法交换为止
     *      删除堆顶元素  为了保持堆的性质，需要对堆进行堆化，使用自顶向下堆化的方法，可以保证数组当中不出现 ”气泡“
     *          1. 将数组当中的最后一个元素放入到堆顶位置
     *          2. 从堆顶开始不断与其左右子结点比较，和较大的子节点交换位置，直到无法交换为止
     * */

    /**
     *  这个 类 的实例使用数组存储的完全二叉树来表示一个大顶堆
     *  并且，完成堆排序
     * */
    public Heap(int[] arr) {
        this.arr = arr;
    }


    /**
     *  获取左子节点索引
     *      i 结点索引
     *      end 结点范围
     *  返回
     *      成功返回获取到子节点的值索引
     *      获取失败返回 null
     * */
    public Integer getLeftNode(int i, int end) {
       int index = 2*i+1;
       if(index < arr.length && index <= end) return index;
       else return null;
    }

    /**
     *  获取右子节点索引
     *      i 结点索引
     *      end 结点范围
     *  返回
     *      成功返回获取到子节点的索引
     *      获取失败返回 null
     * */
    public Integer getRightNode(int i, int end) {
        int index = 2*i+2;
        if(index < arr.length && index <= end) return index;
        else return null;
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *  对范围 [0, end] 自顶向下进行堆化
     * */
    public void heapify(int start, int end) {
        int i=0;
        while (true) {
            Integer left = getLeftNode(i, end);
            Integer right = getRightNode(i, end);

            Integer maxIndex = null;
            if(left != null && right != null) {
                maxIndex = arr[left] > arr[right] ? left : right;

            } else if(left != null) {
                maxIndex = left;
            } else if(right != null) {
                maxIndex = right;
            } else {
                maxIndex = null;
            }

            if(maxIndex != null) {
                if(arr[i] < arr[maxIndex]) {
                    swap(i, maxIndex);
                    i = maxIndex;
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void sort() {
        heapify(0, arr.length-1);
        for(int i=arr.length-1; i>0; i--) {
            swap(0, i);
            heapify(0, i-1);
        }
    }
    public int[] arr;
}
