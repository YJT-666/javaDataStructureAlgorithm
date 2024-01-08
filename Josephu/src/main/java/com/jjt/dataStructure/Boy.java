package com.jjt.dataStructure;

/**
 * ClassName: Boy
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 13:50
 * @Version 1.0
 * Description:
 *      Boy 节点
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy() {
        this.no = 0;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
