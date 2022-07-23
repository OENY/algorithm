package com.example.study.array;

import java.util.Arrays;

/**
 * 动态扩容数组
 */
public class GenericArray<T> {
    /**
     * 底层存储容器用的还是数组
     */
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改index元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);
        // 修改元素
        data[index] = e;
    }

    /**
     * 获取对应index位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 判断是否包含元素 e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 获取指定元素的下标，未找到则设为-1;
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);

        // 如果数组已满,需要扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[index] = e;
        size++;
    }


    /**
     * 向数组头部插入元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 删除指定位置的元素并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T ret = data[index];

        // 倒序移动元素
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 最后一个元素，设为空
        data[size] = null;

        // 当数组大小满足一定条件时，可以进行缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;

    }

    /**
     * 移除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除置顶位置的元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) remove(index);
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    /**
     * 扩容方法,时间复杂度o(n)
     * 申请一个指定大小的数组
     *
     * @param capacity
     */
    private void resize(int capacity) {
        // 申请一个新的数组
        T[] newArray = (T[]) new Object[capacity];

        // 把 原来的数据复制到 新申请的 数组中
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }

        // 指向新的数组
        data = newArray;
    }

    /**
     * 添加时，如果index超出范围会显示异常
     *
     * @param index
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >= 0 and index <size");
        }
    }


    /**
     * 检测索引是否越界
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed! Require index >= 0 and index < size.");
        }
    }


}
