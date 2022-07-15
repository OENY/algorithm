package com.example.study.backtrack;

import org.junit.Test;

/**
 * 八皇后问题：回溯+深度优先搜索算法
 */
public class EightQueens {

    @Test
    public void TestEightQueens() {
        // 定义一个数组来存结果
        calQueens(0);
    }


    // 因为采用的是深度优先搜索算法，所以一个数组就够了
    public int[] result = new int[8];

    /**
     * 八皇后计算
     *
     * @param row
     */
    private void calQueens(int row) {
        // 递归结束条件
        if (row == 8) {
            // 打印符合该结果的八皇后
            printQueens();
            System.out.println("----------------------------");
            return;
        }

        // 递归体

        // 遍历8种选择
        for (int column = 0; column < 8; column++) {
            //每种选择判断是否符合条件，如果不满足条件,则剪枝
            // 注意：这里的column就是一种选择
            if (isOk(column, row)) {
                // 存下来
                result[row] = column;
                // 递进
                calQueens(row + 1);
            }
        }

    }


    /**
     * 判断是否满足，八皇后条件，左上，上，右上，都不能有数
     */
    private boolean isOk(int column, int row) {

        // 左上
        int leftUp = column - 1;
        // 右上
        int rightUp = column + 1;

        // 依次往上遍历，判断是否满足条件
        for (int i = row - 1; i >= 0; i--) {


            // 上
            if (result[i] == column) return false;
            // 左上
            if (leftUp >= 0 && result[i] == leftUp) return false;
            // 右上
            if (rightUp < 8 && result[i] == rightUp) return false;

            leftUp--;
            rightUp++;

        }
        return true;
    }


    /**
     * 打印八皇后
     */
    private void printQueens() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.printf(" Q ");
                }
                System.out.printf(" * ");
                ;
            }
            System.out.println();
        }
    }

}
