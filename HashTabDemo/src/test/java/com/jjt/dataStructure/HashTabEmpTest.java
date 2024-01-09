package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

/**
 * ClassName: HashTabEmpTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 17:25
 * @Version 1.0
 * Description:
 *          HashTabEmpTest 测试
 */
public class HashTabEmpTest {


    @Test
    public void test01() {
        HashTabEmp hashTabEmp = new HashTabEmp();

        Employee employee41 = new Employee(41, "小黑");
        Employee employee21 = new Employee(21, "小明");
        Employee employee22 = new Employee(22, "小红");
        Employee employee23 = new Employee(23, "小李");
        Employee employee1 = new Employee(1, "张三");
        Employee employee2 = new Employee(2, "李四");
        Employee employee3 = new Employee(3, "王二");


        System.out.println("测试添加");
        hashTabEmp.add(employee1);
        hashTabEmp.add(employee2);
        hashTabEmp.add(employee3);
        hashTabEmp.add(employee21);
        hashTabEmp.add(employee22);
        hashTabEmp.add(employee23);
        hashTabEmp.add(employee41);

        hashTabEmp.printAllLinkedList();

        System.out.println("---------------------------");
        System.out.println("测试查找");
        System.out.println(hashTabEmp.find(22));
        System.out.println(hashTabEmp.find(24));

        System.out.println("---------------------------");
        System.out.println("测试删除");
        hashTabEmp.remove(employee22);
        hashTabEmp.remove(employee3);
        System.out.println("移除后");
        hashTabEmp.printAllLinkedList();
    }
}
