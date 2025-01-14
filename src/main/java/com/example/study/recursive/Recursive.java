package com.example.study.recursive;

import org.junit.Test;

public class Recursive {

    /**
     * 求n! 阶乘
     */
    @Test
    public void factorial() {
        System.out.println(factorial(5));
    }

    private long factorial(int n) {
        // 递归结束条件
        if (n == 1) {
            return 1;
        }
        // 递归体
        return n * factorial(n - 1);
    }


    @Test
    public void fibonacci() {
        System.out.println(FibonacciIteration(5));
    }
    /**
     * 斐波那契迭代实现：1，1，2，3，5，8，13
     * @param n 注意n只是斐波那契得索引
     * @return
     */
    private long FibonacciIteration(int n) {
        if(n == 1 || n== 2) {
            return  1;
        }
        // 定义初始得两个值,f1为前1 f2为前2
        int f1 = 1;
        int f2 = 1;

        int res = 0;
        // 注意1只是索引,目前假设斐波那契数据里得索引是从1开始得
        for (int i = 3; i <=n; i++) {

            res = f1+f2;

            // 更新前1和前2元素
            f2= f1;
            f1 = res;
        }
        return res;

    }
}
