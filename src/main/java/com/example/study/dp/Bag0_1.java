package com.example.study.dp;

import org.junit.Test;

// 背包问题：对于一组不同重量、不可分割的物品，我们需要选择一些
// 装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少？
public class Bag0_1 {


    // 动态规划-背包0-1问题：1、递归（回溯）备忘录法 2、 迭代计算法
    @Test
    public void Bag_DP_Test() {
        System.out.println(dp());
    }


    private int maxWeight = Integer.MIN_VALUE;
    private int[] items = {1, 2, 3};
    private int weight = 9;

    /**
     * 回溯法：遍历所有路径，选择符合条件的路径，对于不符合条件的路径，会进行剪枝
     * 调用 f(0,0)
     * System.out.println(maxWeight);
     *
     * @param i         第几个物品
     * @param curWeight 当前重量
     */
    private void f(int i, int curWeight) {
        // 递归结束条件
        if (i == items.length || curWeight == weight) { // 最后一个物品、或者当前重量大于背包重量
            if (curWeight > maxWeight) maxWeight = curWeight;
            return;
        }

        // 递归体：1、不装进背包 2、装进背包
        f(i + 1, curWeight);
        // 注意：这里是items[i]，装的是当前物品，不要写成 items[i+1]
        if (curWeight + items[i] <= weight) {
            f(i + 1, curWeight + items[i]);
        }

    }

    /**
     * 回溯法+备忘录
     * 调用f(0,0)
     * System.out.println(maxWeight);
     * 1、画出递归树
     * 2、寻找规律，找出重复状态
     */
    boolean[][] mem = new boolean[items.length][weight + 1];  // 这里weight 要加+1注意

    private void f_memo(int i, int curWeight) {
        // 递归结束条件
        if (i == items.length || curWeight == weight) { // 最后一个物品、或者当前重量大于背包重量
            if (curWeight > maxWeight) maxWeight = curWeight;
            return;
        }

        // 如果该状态已存在，就不需要再执行递归提了
        if (mem[i][curWeight]) {
            return;
        }
        // 记录状态
        mem[i][curWeight] = true;

        // 递归体：1、不装进背包 2、装进背包
        f(i + 1, curWeight);
        // 注意：这里是items[i]，装的是当前物品，不要写成 items[i+1]
        if (curWeight + items[i] <= weight) {
            f(i + 1, curWeight + items[i]);
        }
    }


    /**
     * 动态规划法：迭代计算
     * 1、划分阶段：这里每个物品相当于一个阶段
     * 2、定义状态，一般用数组来记录这些状态：每个阶段需要定义哪些决策-每个物品是否选择的结果 则成为了一个决策状态
     * 3、用当前阶段的集合状态 推出 下一个阶段的集合状态,推出状态转移方程
     * 4、确定初始阶段状态的初始值，即边界条件
     */

    private int dp() {

        // 定义一个二维数组容器，来存状态
        boolean[][] states = new boolean[items.length][weight + 1];

        // 定义初始阶段状态的值,也就是第一层的初始值
        states[0][0] = true;

        if (items[0] <= weight) {
            states[0][items[0]] = true;
        }

        // 迭代遍历，实现状态转移,同时形成状态转移方程
        for (int i = 1; i < items.length; i++) { // 从最开始的阶段，遍历到最后一个阶段,要理解这里为啥1开始

            // 不装 0
            for (int j = 0; j <= weight; j++) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            // 装 1
            for (int j = 0; j <= weight - items[i]; j++) {
                if (states[i - 1][j] == true) states[i][j + items[i]] = true;
            }
        }

        // 输出结果,最后一层，倒数第一个
        // 本质：把整个递归树，用二维数组画出来了
        for (int i = weight; i >= 0; --i) {
            if (states[items.length - 1][i] == true) return i;
        }

        return 0;

    }

}
