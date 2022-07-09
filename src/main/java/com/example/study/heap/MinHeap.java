package com.example.study.heap;

/**
 * 小顶堆：1、完全二叉树 2、节点的所有子树节点的值都大于该节点的值
 */
public class MinHeap {

    /**
     * 基础数据结构
     */
    private int[] array;
    /**
     * 当前容量
     */
    private int capacity;
    /**
     * 当前节点个数
     */
    private int count;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        // 初始化数组，不使用0下标
        array = new int[capacity + 1];
    }

    /**
     * 插入一个元素-
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= capacity) return;

        ++count;
        array[count] = data;

        //堆化：以实现平衡：仍然采用自底向上堆化
        int i = count;
        while (i / 2 > 0 && array[i] < array[i / 2]) {
            swap(array, i, i / 2);

            // 推进
            i = i / 2;
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
