package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: MazesAnalogTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 22:12
 * @Version 1.0
 * Description:
 *          迷宫小游戏测试类
 */
public class MazesAnalogTest {

    @Test
    public void test01() {
        MazesAnalog mazesAnalog = new MazesAnalog();
        mazesAnalog.setMap2();

        mazesAnalog.printMap();


        mazesAnalog.setWay(1,1);
        mazesAnalog.printMap();

    }
}
