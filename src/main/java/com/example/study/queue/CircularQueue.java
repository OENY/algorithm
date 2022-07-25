package com.example.study.queue;

/**
 * 循环队列:数组+双指针+堆满[(tail+1)%maxSize == head] + 队空[tail == head]
 * 递进原理：tail = (tail+1)%maxsize   head = (head+1)%maxsize
 */
public class CircularQueue {
    // 底层数据结构
    private String[] items;
    // 队列大小，容量
    private int capacity;

    // 出队-指针
    private int head = 0;
    // 入队-指针
    private int tail = 0;//tail始终指这下一个可插入的位置

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队:注意这里少用了一个元素
     *
     * @param data
     * @return
     */
    public boolean enqueue(String data) {
        // 如果队满
        if ((tail + 1) % capacity == head) return false;

        // 入队
        items[tail] = data;
        // 更新tail
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        // 如果队空
        if (head == tail) return null;

        // 出队
        String data = items[head];

        // 更新head
        head = (head + 1) % capacity;
        return data;
    }

    /**
     * head 到tail 元素的输出
     */
    public void printAll() {
        // 注意这里的循环截止条件 ，注意i%capacity != tail 与 队空判断有关
        for (int i = head; i % capacity != tail; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
