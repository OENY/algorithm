package com.example.study.stack;

/**
 * 基于链表的栈
 */
public class StackBasedOnLinkedList {
    private Node top = null;

    /**
     * 入栈-头插法
     *
     * @param value
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断是否为空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 取第一个元素的value，注意这里的链表为不带头节点
     *
     * @return
     */
    public int pop() {
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
