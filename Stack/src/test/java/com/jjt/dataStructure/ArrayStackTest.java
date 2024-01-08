package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: ArrayStackTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 15:13
 * @Version 1.0
 * Description:
 *          用数组模拟栈测试
 */
public class ArrayStackTest {


    @Test
    public void testArrayStack() {
        ArrayStack arrayStack = new ArrayStack();

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        System.out.println("arrayStack = " + arrayStack);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("arrayStack = " + arrayStack);

    }
}
