package com.jjt.dataStructure;

import com.jjt.dataStructure.impl.QueueArray;
import org.junit.jupiter.api.Test;

import java.net.http.WebSocketHandshakeException;

/**
* ClassName: QueueArrayTest
* Package: IntelliJ IDEA
* @Author jjt
* @Create 2023/12/24 0:22
* @Version 1.0
* Description:
*/public class QueueTest {


    @Test
    public void test01() {
        Queue queue = new QueueArray(5);

        System.out.println("before insert ----------------------");
        System.out.println("queue: "+ queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.maxSize() = " + queue.getMaxSize());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        int[] array1 = {1, 2, 3, 4, 5};

        for (int i = 0; i < array1.length; i++) {
            queue.push(array1[i]);
        }

        System.out.println("After insert ----------------------");
        System.out.println("queue: "+ queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.maxSize() = " + queue.getMaxSize());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + "\t");
        }
        System.out.println();

        System.out.println("After pop ----------------------");
        System.out.println("queue: "+ queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.maxSize() = " + queue.getMaxSize());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
}
