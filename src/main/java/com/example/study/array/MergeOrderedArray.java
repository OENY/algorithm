package com.example.study.array;

import org.junit.Test;

/**
 * 合并两个有序数组
 */
public class MergeOrderedArray {

    @Test
    public void mergeOrderedArrayTest() {
        int[] arr1 = {1, 2, 9};
        int[] arr2 = {1, 4, 6};
        int[] arr = mergeOrderedArray_1(arr1, arr2);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    /**
     * 合并有序数组,两个数组
     *
     * @return
     */
    private int[] mergeOrderedArray_1(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int[] tmp = new int[arr1.length + arr2.length];
        int k = 0;

        // 合并两个有序数组
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                tmp[k++] = arr1[i++];
            } else {
                tmp[k++] = arr2[j++];
            }
        }

        // 把剩余元素添加至 tmp
        while (i < arr1.length) tmp[k++] = arr1[i++];
        while (j < arr2.length) tmp[k++] = arr2[j++];

        return tmp;
    }

    /**
     * 合并两个数组，原地合并 ,假设 low,mid  和 mid , high之间都是有序数组
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private void mergeOrderedArray_2(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] tmp = new int[high - low + 1];
        int k = 0;

        // 合并有序数组
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 把剩余元素添加至tmp
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];

        // 讲tmp元素复制回arr
        for (int x = 0; x < tmp.length; x++) {
            arr[low + x] = tmp[x];
        }
    }


}
