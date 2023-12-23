package com.jjt.dataStructure;

/**
 * ClassName: Queue
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2023/12/23 23:28
 * @Version 1.0
 * Description:
 *
 *          自定义队列接口
 */
public interface Queue<T> {

    /**
     *  判断队列是否满
     * @return the boolean
     */
    public Boolean isFull();

    /**
     *  返回队列是否为空
     *
     * @return the boolean
     */
    public Boolean isEmpty();

    /**
     * 向队列当中添加元素
     *
     * @param element  要添加的元素
     */
    public void push(T element);

    /**
     * 获取队列的最大长度
     *
     * @return the max size
     */
    public int getMaxSize();

    /**
     * 返回队列的大小
     *
     * @return the int
     */
    public int size();

    /**
     * 队列元素出列
     *
     * @return the t
     */
    public T pop();

    /**
     * 获取队列头部元素，不取出数据
     *
     * @return the t
     */
    public T head();
}
