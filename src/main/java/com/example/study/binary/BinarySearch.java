package com.example.study.binary;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5};
        int i = binarySearchFirstBig(arr, 3);
        System.out.println(i);
    }

    /**
     * 二分查找
     *
     * @param arr
     * @return
     */
    private static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;


        // 不断循环
        while (low <= high) {
            int mid = (high + low) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 题目，找大于等于给定值的第一个元素
     *
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearchFirstBig(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == arr[mid]) {
                // 找到了,然后右移，极客找到 大于 等于给定值的第一个元素
                if (mid + 1 <= arr.length - 1) {
                    return arr[mid + 1]; // 注意：如果是大于的话，则需要不断右移，只有不等于，且大于arr[mid]时，才是想要的，否则不是
                }
                return -1;
            } else if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
