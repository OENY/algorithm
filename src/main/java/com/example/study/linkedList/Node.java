package com.example.study.linkedList;



/**
 * @Author: yuanchenglong
 * @Description: 节点
 * @Date: 2022/6/9 11:18
 */


public class Node {
    /**
     * 数据域
     */
    Integer data;
    /**
     * 指针域
     */
    Node next;

    public Node() {
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
