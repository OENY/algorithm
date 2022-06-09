package com.example.study.linkedList;

/**
 * @Author: yuanchenglong
 * @Description: 链表常用操作接口定义
 * @Date: 2022/6/9 11:27
 */
public interface LinkedList{


    /**
     * 添加到头部
     * @param element
     */
    void addToHead(Integer element);

    /**
     * 添加到尾部
     * @param element
     */
    void addToTail(Integer element);

    /**
     * 添加到指定位置
     * @param index
     */
    void add(Integer element,int index);

    /**
     * 获取制定索引的元素
     * @param index
     * @return
     */
    Node get(int index);


    /**
     * 获取链表大小
     * @return
     */
    int size();

    /**
     * 删除制定索引的node
     * @param index
     * @return
     */
    Node remove(int index);

}
