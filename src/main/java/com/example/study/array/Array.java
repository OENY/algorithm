package com.example.study.array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 1)数组的插入、删除、按照下标随机访问操作
 * 2)数组中的数据是int类型的
 */
public class Array {
    /**
     * 底层存储容器
     */
    public int data[];

    /**
     * 定义数组长度
     */
    private int n;

    /**
     * 定义中的实际个数
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;// 初始个数为0
    }

    /**
     * 根据索引，找到数据中的元素并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    /**
     * 插入元素
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        // 如果数组空间已满，则无法插入元素
        if (count == n) {
            System.out.println("没有可插入");
            return false;
        }

        // 插入位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        // 位置合法，可以插入,先移动
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        // 插入
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
    }


}
