package com.example.study.sort;

import org.junit.Test;

/**
 * @Author: yuanchenglong
 * @Description: 冒泡排序
 * @Date: 2022/6/14 21:00
 */
public class Sort {


    /**
     * 冒泡排序-实现思路：将无序区间的数据依次进行两两比较，不满足条件则替换位置，这里以升序为例，如果a[i]>[a[i+1]，则替换位置，一轮下来之后
     * ，数值最大的数据将放在末尾，  优化：以后每轮比较，无需遍历至前面 已经冒泡后的 数了
     */
    @Test
    public void BubbleSort(){
        int[] arr = new int[]{6,5,7,8,9,1,3,2};

        for (int i = 0; i < arr.length; i++) {
            // 注意：这里-i 是因为已经冒泡后的数据，不需要再比较了
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

        // 遍历
        printArr(arr);

    }


    private void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    /**
     * 交换数组中的两个数
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}