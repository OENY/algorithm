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

    /**
     * 组合问题：从n个不同元素中，任取m个元素组成一组（m<=n）,叫做从n个不同元素中取出m个元素的一个组合
     * 本质：从n个数中，选k个数的组合
     */
    @Test
    public void combineTest() {
        int n = 6;
        int k = 3;
        // 结果集
        List<List<Integer>> result = new ArrayList<>();
        // 路径
        List<Integer> path = new ArrayList<>();
        combine(n,k,0,path,result);
        System.out.println(result);
    }


    private void combine(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        // 递归截止条件：路径长度等于k
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历选择列表
        for(int i = start; i < n; i++){
            // 做选择
            path.add(i);

            // 递归调用
            combine(n,k,i+1,path,result);

            // 回溯：撤销选择
            path.remove(path.size()-1);
        }

    }

    /**
     * 子集问题：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
     * 1、子集问题，可以转化为组合问题
     * 2、从n个数中，选k个数的组合
     * 3、k的取值范围是[0,n]
     */
    @Test
    public void subSetTest(){
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subSet(nums,0,path,result);
        System.out.println(result);
    }

    /**
     * 子集问题
     * @param nums
     * @param start
     * @param path
     * @param result
     */
    private void subSet(int[] nums, int start,List<Integer>path, List<List<Integer>> result) {
        // 递归截止条件:因为是求所有子集，所以全部都保存下来
        result.add(new ArrayList<>(path));

        // 遍历选择列表
        for(int i = start; i < nums.length; i++){
            // 做选择
            path.add(nums[i]);
            // 递归
            subSet(nums,i+1,path,result);
            // 撤销选择：回溯
            path.remove(path.size()-1);
        }

    }
}
