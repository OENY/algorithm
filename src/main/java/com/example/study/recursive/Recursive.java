package com.example.study.recursive;

import com.example.study.util.AlgUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



    @Test
    public void permuteTest() {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0,result);

        System.out.println(result);

    }

    /**
     * 全排列思路：
     * 1、通过递归回溯,首先固定一个元素，然后生成剩余元素的全排列
     * 2、本质是：所有全素都可以放在首位
     * 3、除了for循环，递归遍历，也是可以输出遍历结果的
     *
     * 优化方式：已经使用过的元素，就直接略过
     * @param nums 待排列的数组
     * @param start 从start开始遍历
     * @param result 结果集
     */
    private void permute(int[] nums, int start, List<List<Integer>> result) {

        // 递归截止条件  遍历到数组尾部，说明，此时已生成一个路径
        if(start == nums.length-1){
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            result.add(tempList);
        }

        // 递归体

        // 遍历所有路径
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            // 交换元素
            AlgUtil.swap(nums,start,i);
            //递归调用
            permute(nums,start+1,result);
            // 回溯
            AlgUtil.swap(nums,start,i);
        }
    }
}
