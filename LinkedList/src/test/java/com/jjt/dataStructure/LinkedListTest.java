package com.jjt.dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ClassName: LinkedListTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/5 17:18
 * @Version 1.0
 * Description:
 */
public class LinkedListTest {

    SingleLinkedList list;
    DoubleLinkedList dList;
    HeroNode hero1;
    HeroNode hero2;
    HeroNode hero3;
    HeroNode hero4;

    @BeforeEach
    public void addHeros2Link() {
        hero1 = new HeroNode(1, "宋江", "及时雨");
        hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        hero3 = new HeroNode(3, "吴用", "智多星");
        hero4 = new HeroNode(4, "林冲", "豹子头");

        list = new SingleLinkedList();
        dList = new DoubleLinkedList();

    }


    /**
     * 添加到链表的尾部
     */
    @Test
    public void HeroSingleLinkedListTest01() {

        list.add(hero1);
        list.add(hero4);
        list.add(hero3);
        list.add(hero2);

        list.printList();
    }

    /**
     * 根据英雄no排名添加到链表的尾部
     */
    @Test
    public void HeroSingleLinkedListTest02() {

        HeroNode hero5 = new HeroNode(4, "林冲2", "豹子头2");
        HeroNode hero6 = new HeroNode(4, "林冲3", "豹子头3");

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);

        list.printList();
    }


    @Test
    public void HeroSingleLinkedListTest03() {
        HeroNode hero5 = new HeroNode(4, "林冲2", "豹子头2");
        HeroNode hero6 = new HeroNode(5, "林冲3", "豹子头3");

        SingleLinkedList list = new SingleLinkedList();

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);

        list.printList();

        System.out.println("--------------------------------");

        list.update(hero5);

        list.printList();

        list.update(hero6);

    }

    @Test
    public void HeroSingleLinkedListTest04() {

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);


        list.printList();
        System.out.println("len = " + list.getLength());

        System.out.println("--------------------------------");

        list.del(3);
        list.del(2);
        list.printList();
        System.out.println("len = " + list.getLength());

    }

    @Test
    public void HeroSingleLinkedListTest05() {

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);


        list.printList();
        System.out.println("--------------------------------");
        System.out.println(list.findLastIndexNode(4));
    }


    @Test
    public void HeroSingleLinkedListTest06() {

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);


        list.printList();
        System.out.println("--------------------------------");

        list.reverse();
        list.printList();
    }

    @Test
    public void HeroSingleLinkedListTest07() {

        list.addByNo(hero4);
        list.addByNo(hero3);
        list.addByNo(hero1);
        list.addByNo(hero2);


        list.printList();
        System.out.println("--------------------------------");

        list.printListReverse();
    }

    @Test
    public void HeroSingleLinkedListTest08() {


        SingleLinkedList list1 = new SingleLinkedList();

        HeroNode hero5 = new HeroNode(5, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(6, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(7, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");

        list.addByNo(hero6);
        list.addByNo(hero3);
        list.addByNo(hero8);
        list.addByNo(hero2);

        list1.addByNo(hero5);
        list1.addByNo(hero1);
        list1.addByNo(hero7);
        list1.addByNo(hero4);


        list.printList();
        list1.printList();
        System.out.println("--------------------------------");

        list.mergeOrderList(list1);
        list.printList();
    }

    /////////////////////////////////////////////////////


    @Test
    public void HeroDoubleLinkedListTest01() {
        dList.add(hero1);
        dList.add(hero2);
        dList.add(hero3);
        dList.add(hero4);

        dList.printList();
    }

    /**
     * 根据英雄no排名添加到链表的尾部
     */
    @Test
    public void HeroDoubleLinkedListTest02() {

        HeroNode hero5 = new HeroNode(4, "林冲2", "豹子头2");
        HeroNode hero6 = new HeroNode(4, "林冲3", "豹子头3");

        dList.addByNo(hero4);
        dList.addByNo(hero3);
        dList.addByNo(hero1);
        dList.addByNo(hero2);

        dList.printList();
    }


    @Test
    public void HeroDoubleLinkedListTest03() {
        HeroNode hero5 = new HeroNode(4, "林冲2", "豹子头2");
        HeroNode hero6 = new HeroNode(5, "林冲3", "豹子头3");

        dList.addByNo(hero4);
        dList.addByNo(hero3);
        dList.addByNo(hero1);
        dList.addByNo(hero2);

        dList.printList();

        System.out.println("--------------------------------");

        dList.update(hero5);

        dList.printList();

       // dList.update(hero6);

    }

    @Test
    public void HeroDoubleLinkedListTest04() {

        dList.addByNo(hero4);
        dList.addByNo(hero3);
        dList.addByNo(hero1);
        dList.addByNo(hero2);


        dList.printList();
        System.out.println("len = " + dList.getLength());

        System.out.println("--------------------------------");

        dList.del(3);
        dList.del(2);
        dList.printList();
        System.out.println("len = " + dList.getLength());

    }

    @Test
    public void HeroDoubleLinkedListTest05() {

        dList.addByNo(hero4);
        dList.addByNo(hero3);
        dList.addByNo(hero1);
        dList.addByNo(hero2);


        dList.printList();
        System.out.println("--------------------------------");
        System.out.println(dList.findLastIndexNode(4));
    }

}
