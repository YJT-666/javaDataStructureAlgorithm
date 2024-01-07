package com.jjt.dataStructure;

import java.util.Arrays;

/**
 * ClassName: ArrayStack
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 15:00
 * @Version 1.0
 * Description:
 *      使用数组来模拟栈
 */
public class ArrayStack {

    private Integer[] array;
    private int maxSize;
    private int top;

    public ArrayStack() {
        this.maxSize = 64;
        top = -1;
        array = new Integer[maxSize];
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        array = new Integer[maxSize];
    }

    /**
     * TODO:
     *      判断栈是否满
     * */
    boolean isFull() {
        return top >= maxSize - 1;
    }

    /**
     * TODO:
     *      判断栈是否为空
     * */
    boolean isEmpty() {
        return top <= - 1;
    }

    /**
     * TODO:
     *      返回当前栈中的元素个数
     * */
    int getSize() {
        return top + 1;
    }

    /**
     * TODO:
     *      入栈
     *      1. 栈顶指针先++
     *      2. 往数组当中存入数据
     * */
    void push(Integer e) {
        if(isFull()) {
            throw new RuntimeException("栈已满");
        }
        array[++top] = e;
    }

    /**
     * TODO:
     *      出栈
     *      1. 返回栈顶的元素 array[top]
     *      2. 栈顶指针--
     * */
    Integer pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return array[top--];
    }


    @Override
    public String toString() {
        String str =  "ArrayStack{";

        for (int i = 0; i < getSize(); i++) {
            str += array[i];
            if(i != getSize()-1) {
                str += ",";
            }
        }
        str+='}';
        return str;
    }
}
