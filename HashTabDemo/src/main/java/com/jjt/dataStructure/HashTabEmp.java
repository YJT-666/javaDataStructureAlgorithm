package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HashTabEmp
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 17:07
 * @Version 1.0
 * Description:
 *          管理雇员对象的 hash 表
 */
public class HashTabEmp {
    int maxSize;   // 决定hashTab最多可以保存多少条雇员链表
    EmployLinkedList[] hashTab;   // 是一个EmployLinkedList数组，用于保存雇员信息

    public HashTabEmp() {
        this(20);
    }

    public HashTabEmp(int maxSize) {
        this.maxSize = maxSize;
        hashTab = new EmployLinkedList[maxSize];
        // 创建所有的 EmployLinkedList
        for (int i = 0; i < maxSize; i++) {
            hashTab[i] = new EmployLinkedList();
        }
    }

    /**
     *  添加雇员
     * */
    public void add(Employee employee) {
        // 1. 根据员工的 id ，得到该员工，应该添加到 empLinkedList 在数组当中的偏移
        int no = hashFun(employee.getId());
        //2. 放入
        hashTab[no].add(employee);
    }

    /**
     *  查找雇员
     * */
    public Employee find(int id) {
        int no = hashFun(id);
        return hashTab[no].find(id);
    }

    /**
     *  删除雇员
     * */
    public void remove(Employee employee) {
        // 1. 根据员工的 id ，得到该员工， empLinkedList 在数组当中的偏移
        int no = hashFun(employee.getId());
        //2. 删除
        hashTab[no].remove(employee);
    }

    /**
     * 散列函数，使用简单的取模方法
     * */
    public int hashFun(int id) {
        return id % maxSize;
    }

    /**
     *  遍历所有的链表
     *  遍历hashTab
     * */
    public void printAllLinkedList() {
        System.out.println("HashTabEmployee: ");
        for (int i = 0; i < maxSize; i++) {
            hashTab[i].printLinkedList();
        }
    }
}
