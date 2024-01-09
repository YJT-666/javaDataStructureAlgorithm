package com.jjt.dataStructure;

/**
 * ClassName: EmployLinkedList
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 16:53
 * @Version 1.0
 * Description:
 *               表示链表
 *
 */
public class EmployLinkedList {
    // 头指针，指向第一个 employee
    private Employee head; // 默认为空

    /**
     *  添加雇员到链表
     *  根据 id 的顺序插入
     * */
    public void add(Employee employee) {
        if(head == null) {
            // 空链表，直接添加即可
            head = employee;
            return;
        }
        Employee tempPre = head;
        Employee temp = tempPre.getNext();
        //
        while (temp != null) {
            if(employee.getId() >= temp.getId()) {
                tempPre = temp;
                temp = temp.getNext();
            }
        }
        tempPre.setNext(employee);
        employee.setNext(temp);
    }

    /**
     *  删除指定的的员工
     * */
    public void remove(Employee employee) {
        if(head == null) {
            // 没有元素可删，直接返回
            return;
        }
        if(head.equals(employee)) {
            // 要删除的元素是头节点
            head = head.next;
            return;
        }
        Employee temp = head;
        while (temp != null && temp.getNext() != null) {
            if(temp.getNext().equals(employee)) {
                // 找到，删除
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }

    /**
     *  根据雇员的 id 查找雇员
     * */
    public Employee find(int id) {
        Employee temp =head;
        while (temp != null) {
            if(temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    /**
     *  遍历链表
     * */
    public void printLinkedList() {
        System.out.print("[ ");
        Employee temp = head;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.getNext();
        }
        System.out.println("]");
    }


}
