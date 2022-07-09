package com.example.study.heap;


/**
 * 大顶堆：1、完全二叉树 2、所有节点大于 左右子子树中所有节点的值
 * 底层数据结构：数组-因为完全二叉树，适合用链表实现
 */
public class MaxHeap {
    /**
     * 底层数据结构
     */
    private int[] array;
    /**
     * 堆容量
     */
    private int capacity;
    /**
     * 当前节点个数
     */
    private int count;

    public MaxHeap(int capacity) {
        // 这里+1是因为不想使用数组下标0
        array = new int[capacity + 1];
        this.capacity = capacity;
    }


    /**
     * 往堆中（隐含条件），插入一个元素-也是一个堆化的过程
     *
     * @param data
     */
    public void insert(int data) {
        // 满了，插不进去了
        if (count >= capacity) {
            return;
        }

        // 直接插入到数组尾部，然后自底向上堆化
        ++count;
        array[count] = data;

        // 和父元素进行比较，然后替换，直至满足大顶堆的条件
        int i = count;
        while (i / 2 > 0 && array[i] > array[i / 2]) {
            swap(array, i, i / 2);
            i = i / 2;
        }

    }


    /**
     * 移除堆顶元素：1、将最后一个元素放到对顶， 2、 然后从上往下依次调整-自顶向下堆化
     */
    public void removeMax() {
        if (count <= 0) return;
        // 1、移除堆顶元素，并将最后一个元素移动到该位置
        array[1] = array[count];
        --count;

        // 2、自顶向下堆化
        int i = 1;// 从1开始
        while (true) {

            // 每次默认i处为最大值
            int maxPos = i;

            // 三数比较，记录最大值
            if (2 * i <= count && array[2 * i] > array[maxPos]) maxPos = 2 * i;
            if (2 * i + 1 <= count && array[2 * i + 1] > array[maxPos]) maxPos = 2 * i;

            // 说明已满足堆化条件
            if (maxPos == i) {
                return;
            }

            swap(array, i, maxPos);

            // 继续遍历
            i = maxPos;
        }
    }


    /**
     * 交换两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
