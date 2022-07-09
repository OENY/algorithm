package com.example.study.heap;

import com.example.study.util.AlgUtil;
import org.junit.Test;

/**
 * 堆排序:注意这里的数组下标，不使用下标0,如果要使用下标0，则节点i的leftChild=2*i+1,rightChild=2*i+2
 */
public class HeapSort {

    @Test
    public void app() {
        int[] array = new int[]{0, 99, 2, 4, 3};
        heapSort(array, array.length - 1);
        for (int i = 1; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * @param array 默认不使用下标0 ，元素从1开始
     * @param count 表示1-n的元素个数
     */
    private void heapSort(int[] array, int count) {
        // 建堆
        buildHeap(array, count);


        // 排序：将栈顶元素，放入末尾，同时尾部元素放入栈顶，然后从栈顶 自顶向下堆化，依次减少count的个数
        int k = count; // 赋值后不影响count
        // 只要栈里还有元素
        while (k > 1) {
            AlgUtil.swap(array, 1, k);
            --k;
            heapify(array, 1, k); // 这里传入1，代表自顶向下排序
        }
    }

    /**
     * 建堆
     *
     * @param array 默认不使用下标0,如果使用的话 则 i的leftChild=2*1+1，leftChild = 2*i+2;,以此类推
     * @param count 当前堆元素个数
     */
    private void buildHeap(int[] array, int count) {
        // 从最后一个非叶子节点，依次往堆顶，进行对话
        for (int i = count / 2; i >= 1; i--) {
            heapify(array, i, count);
        }
    }


    /**
     * 自顶向下堆化
     *
     * @param array
     * @param startIdx 如果从栈顶开始堆化，这里可以设为1
     * @param count
     */
    private void heapify(int[] array, int startIdx, int count) {

        int i = startIdx;
        while (true) {
            int maxPos = i;

            // 注意：这里 2*i <= count 的等号不能取消，要注意这些边界条件
            if (2 * i <= count && array[2 * i] > array[maxPos]) maxPos = 2 * i;
            if (2 * i + 1 <= count && array[2 * i + 1] > array[maxPos]) maxPos = 2 * i + 1;
            if (maxPos == i) {
                return;
            }

            AlgUtil.swap(array, i, maxPos);
            i = maxPos;
        }
    }


}
