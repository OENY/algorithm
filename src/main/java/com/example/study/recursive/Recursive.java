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
}
