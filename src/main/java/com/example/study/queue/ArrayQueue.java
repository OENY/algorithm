package com.example.study.queue;

/**
 * 顺序队列的实现:需要维护两个指针
 */
public class ArrayQueue {
    /**
     * 底层数据结构-数组
     */
    private String[] items;
    /**
     * 数组大小-n-capacity
     */
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队-从尾部入队 todo：这里通过改进，也可以实现动态数组，主要利用将head,tail的数据 搬移到前部
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) return false;
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        // 队列为空
        if (head == tail) {
            // 重置head、tail
            head = 0;
            tail = 0;
            return null;
        }

        String ret = items[head];
        ++head;
        return ret;
    }

    private void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }


}
