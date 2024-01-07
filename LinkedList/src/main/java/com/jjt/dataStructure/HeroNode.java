package com.jjt.dataStructure;

/**
 * ClassName: HeroNode
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/5 17:01
 * @Version 1.0
 * Description:
 *              英雄节点
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;   // 指向下一个节点
    public HeroNode pre;    // 指向前一个节点

    public HeroNode() {
        this.no = 0;
        this.name = null;
        this.nickname = null;
        this.next = null;
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.next = null;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
