package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: JosephuTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 14:09
 * @Version 1.0
 * Description:
 *          约瑟夫问题测试
 */
public class JosephuTest {


    @Test
    public void testJosephu01() {

        Josephu josephu = new Josephu(5);

        josephu.printCircleLinkedList();

        josephu.popCircle(2);
    }

}
