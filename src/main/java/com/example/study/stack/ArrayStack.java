package com.example.study.stack;

/**
 * 顺序栈
 */
public class ArrayStack {
    /**
     * 底层数组结构-数组
     */
    private String[] items;
    /**
     * 栈的大小
     */
    private int n;
    /**
     * 栈中元素个数
     */
    private int count;

    /**
     * 初始化数组，申请一个大小为n的数组空间
     *
     * @param n
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        // 栈满，则入栈失败
        if (count == n) return false;
        items[count++] = item;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {
        if (count == 0) return null;
        // 这里减1，和入栈时有关，特别注意一下
        String tmp = items[count - 1];
        --count;
        return tmp;

    }

}
