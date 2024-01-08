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
 *          用单向链表模拟栈测试
 */
public class SignleLinkedListStackTest {


    @Test
    public void testSignleLinkedListStack() {
        SingleLinkedListStack stack = new SingleLinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("stack = " + stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("stack = " + stack);

    }
}
