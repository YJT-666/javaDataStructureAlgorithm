package com.jjt.dataStructure;

import java.util.Objects;

/**
 * ClassName: Employee
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/9 16:50
 * @Version 1.0
 * Description:
 *     雇员类
 */
public class Employee {
    private Integer id;
    private String name;
    public Employee next;  // 默认为null  指向下一个雇员

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
