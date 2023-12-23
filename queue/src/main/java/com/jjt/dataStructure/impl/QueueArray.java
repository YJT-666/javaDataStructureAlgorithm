package com.jjt.dataStructure.impl;

import com.jjt.dataStructure.Queue;

/**
 * ClassName: QueueArray
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2023/12/23 23:37
 * @Version 1.0
 * Description:
 *          使用数组来实现环形队列
 *
 *          TODO:
 *               使用数组来模拟环形队列
 *               数组最大长度为   maxSize , 默认为 11；但是队列的最大存储元素个数为  maxSize-1 = 10
 *               指针 front 指向队列的头
 *               指针 rear  指向队列的最后一个元素的后一个位置，空出一个位置作为判断队列是否为满
 *               1.初始时：front = rear = 0
 *               2.队列为空：front=rear
 *               3.队列含有元素时:
 *                  0      1     2     3
 *                  front  rear
 *                  rear   front
 *                  - 队列的大小 size = (rear-front + maxSize) % maxSize
 *               4.队列为满时
 *                  0     1     2    3
 *                  rear  front
 *                  - 队列上最大可以存储的容量其实是数组最大长度maxSize-1
 *                  - 满足 (rear+1)% maxSize == front
 */
public class QueueArray<T> implements Queue<T> {

    private int maxSize = 11;
    private T[] array;
    private int front = 0;
    private int rear = 0;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize + 1;
        array = (T[])new Object[maxSize];
    }

    public QueueArray() {
        array = (T[])new Object[maxSize];
    }

    @Override
    public int size() {
        return (rear-front + maxSize) % maxSize;
    }

    @Override
    public Boolean isFull() {
        return (rear+1)%maxSize==front;
    }

    @Override
    public Boolean isEmpty() {
        return rear==front;
    }

    @Override
    public void push(T element) {
        if(!isFull()) {
            array[rear++] = element;
            if (rear >= maxSize) {
                rear = 0;
            }
        }
    }

    @Override
    public T pop() {
        if(!isEmpty()) {
            T res = array[front++];
            if(front >= maxSize) {
                front = 0;
            }
            return res;
        }
        return null;
    }

    @Override
    public T head() {
        if(!isEmpty()) {
            return array[front];
        }
        return null;
    }

    @Override
    public int getMaxSize() {
        return maxSize-1;
    }

    @Override
    public String toString() {
        if(!isEmpty()) {
            int front1 =front;
            int rear1 =rear;
            String res = "[\t";
            while (rear1 != front1) {
                res += array[front1++];
                res += "\t";
                if(front1 >= maxSize)  front1 = 0;
            }
            res += "]";
            return res;
        }
        return "[]";
    }
}
