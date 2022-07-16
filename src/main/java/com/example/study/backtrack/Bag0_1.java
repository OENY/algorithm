package com.example.study.backtrack;

import org.junit.Test;

/**
 * 0-1背包问题：对于每个物品来说，都有两种选择，装进背包或者不装进背包。对于n个物品来说，总的装法就有2^n中
 * 解决思路：每个物品就代表一个阶段 s1:s2:s3:s4.....  每个物品可以选择装或者不装，从而每个阶段就有两种选择0或1
 * 该问题，属于数学里的 组合问题，因为这些阶段，不分前后，属于组合问题
 * <p>
 * 基本思想：穷举法（递归实现）-从中选择Max最优的状态
 */
public class Bag0_1 {


    @Test
    public void BagTest() {
        int[] items = {2, 3, 5, 7, 8, 9};
        int w = 6;
        f(0, 0, items, items.length, w);
        System.out.println(maxW);
    }


    public int maxW = Integer.MIN_VALUE;

    /**
     * @param i     遍历到第i个物品，即第i个节点
     * @param cw    到第i个阶段时，选择装进背包的物品重量
     * @param items 每个物品对应的重量
     * @param n     总的物品个数，即所有的阶段
     * @param w     背包重量
     */
    private void f(int i, int cw, int[] items, int n, int w) {
        //递归结束条件：1、已经到最后一个阶段（最后一个物品）2、选择的物品重量大于背包的重量（大于限制条件时）
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }
        //递归体：选择装或者不装

        // 不装 0
        f(i + 1, cw, items, n, w);
        // 装   1
        if (cw + items[i] <= w) { // 能装进去，才能装 ，想装，装不进去的，就自动不往下走了，也就是剪枝了
            f(i + 1, cw + items[i], items, n, w);
        }

    }

}
