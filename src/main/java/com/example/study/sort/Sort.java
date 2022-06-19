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


    /**
     * 插入排序-实现思路: 把数组分为两个区间，有序区间和无序区间【注意：一个数，是有序的】，随机从无序区间中，取数，插入至有序区间
     */
    @Test
    public void InsertionSort(){
        int[] arr = new int[]{6,5,7,8,9,1,3,2};

        for (int i = 1; i < arr.length; i++) {

            // 记录插入的数据的值
            int value = arr[i];
            int j = i-1;

            for (;j >=0 ;j--){
                if(arr[j] > value){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }

            // 插入数据
            arr[j+1] = value;

        }

        printArr(arr);
    }


    /**
     * 选择排序-实现思路：有序区间和无序区间，找出无序区间的最小值，插入至有序区间的末尾
     */
    @Test
    public void SelectionSort(){
        int[] arr = new int[]{6,5,7,8,9,1,3,2};

        for (int i = 0; i < arr.length; i++) {
            // 记录最小值索引
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                // 找出无序区间的最小值
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 将最小值插入至有序区间的末尾
            swap(arr, min, i);
        }

        printArr(arr);
    }

    /**
     * 归并排序：分而治之+划分两个区间+递归+合并有序数组
     */
    @Test
    public void MergeSortTest() {
        int[] arr = new int[]{6, 5, 7, 8, 9, 1, 3, 2};
        int low = 0;
        int high = arr.length - 1;

        mergeSort(arr, low, high);

        printArr(arr);
    }


    /**
     * 归并排序
     *
     * @param arr
     * @param low
     * @param high
     */
    private void mergeSort(int[] arr, int low, int high) {

        // 递归截止条件
        if (low >= high) {
            return;
        }
        // 获取中间点
        int mid = (low + high) / 2;

        // 划分两个区间，分别各自合并
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // 合并两个有序数组
        mergeSeqArr(arr, low, mid, high);

    }

    /**
     * 合并两个有序数组
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    private void mergeSeqArr(int[] arr, int low, int mid, int high) {
        // todo:定义临时数组 关注点 +1  | 导致空间复杂度 升为O(n)
        int[] res = new int[high - low + 1];

        int i = 0;

        int p = low;
        int q = mid + 1;

        // 双指针法
        while (p <= mid && q <= high) {
            if (arr[p] < arr[q]) {
                res[i++] = arr[p++];
            } else {
                res[i++] = arr[q++];
            }
        }
        if (p <= mid) {
            while (p <= mid) {
                res[i++] = arr[p++];
            }
        }

        if (q <= high) {
            while (q <= high) {
                res[i++] = arr[q++];
            }
        }

        // todo:将临时数组中的数据拷贝至arr
        for (int j = 0; j < res.length; j++) {
            // 临时数组res只是 arr的子区间而已
            arr[low + j] = res[j];
        }

    }


    /**
     * 快速排序思想:分而治之+先总体后局部有序+递归+哨兵【可从首或者尾部选取数据，技巧：将该数据用临时变量存储起来】
     * 编码核心：哨兵+左找右+右找左
     * 时间复杂度：log(n)
     * 优势：原地排序  和归并排序比较
     */
    @Test
    public void quickSortTest() {
        int[] arr = new int[]{6, 5, 7, 8, 9, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }


    private void quickSort(int[] arr, int low, int high) {

        // 递归结束条件
        if (low >= high) {
            return;
        }

        // 取arr的第一个元素value，将arr根据大于value或者小于 划分两个区域，返回分区点下标
        int pivot = pivot(arr, low, high);
        // 以分区点下标，划分两个区间，分别进行快速排序
        quickSort(arr, low, pivot);
        quickSort(arr, pivot + 1, high);

    }

    private int pivot(int[] arr, int start, int end) {
        // 选取 arr 第一个元素
        // 选取元素，与arr进行比较，并移动数据

        // 定义双指针
        int low = start;
        int high = end;


        // 先假设哨兵为第一个元素
        int guard = low;
        int guardValue = arr[low];

        while (low <= high) {
            // 核心：左找右-小，右找左-大 | 哨兵在左边，从右边开始比较找比哨兵小的元素，哨兵在右边，找比哨兵大的元素

            // 说明哨兵在左边
            if (guard == low) {
                // 哨兵在左，从右边找比哨兵小的元素
                if (arr[high] < guardValue) {
                    // 交换哨兵位置
                    swap(arr, guard, high);

                    // 更新哨兵交换后的位置信息
                    guard = high;
                } else {
                    high--;
                }
            }


            // 说明哨兵在右边
            if (guard == high) {
                // 如果哨兵在右，从左找找比哨兵大的元素
                if (arr[low] > guardValue) {
                    // 交换哨兵位置
                    swap(arr, guard, low);

                    // 更新哨兵交换后的位置信息
                    guard = low;

                } else {
                    low++;
                }
            }
        }
        return guard;
    }


    private void printArr(int[] arr) {
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
