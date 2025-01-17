package com.example.study.heap;

import com.example.study.util.AlgUtil;

/**
 * 最大堆实现
 * @Author: ycl
 * @Date: 2025/1/17
 * @Time: 14:57
 */
public class MaxHeap {
    // 数组用于存储堆得数据
    private int[] data;
    // 当前存储得元素个数
    private int count;
    // 总容量
    private int capacity;
    public MaxHeap(int capacity){
        this.data = new int[capacity];
        this.count = 0;
        this.capacity = capacity;
    }


    /**
     * 插入数据一般放在尾部
     * @param value
     */
    public void insert(int value){
        // 判断是否达到容量
        if(count +1 > capacity){
            throw new RuntimeException("堆已满");
        }

        // 将插入的元素存储在末尾,没插入之前，最后一个元素应该是data[count-1]
        data[count] = value;
        heapifyUp(count);
        count++;
    }

    /**
     * 向上堆化：将最后一个元素与其父元素进行比较，如果大于父元素，则交换，如果小于父元素，则停止交换，说明已经堆化成功
     * @param k k表示当前元素的索引
     */
    private void heapifyUp(int k){
        int parent = (k-1)/2;
        while(parent >= 0 && data[k] > data[parent]){
            AlgUtil.swap(data,k,parent);
            // 将k指向父元素
            k = parent;
            // 更细parent元素
            parent = (k-1)/2;
        }
    }

    /**
     * 删除堆顶元素，及最大值
     * 将末尾元素移动到最顶，然后分别与左右子节点进行比较，选出最大值依次类推
     * @return 返回删除得元素
     */
    public int deleteMax(){
        if(count == 0){
            throw new RuntimeException("堆为空");
        }
        int max = data[0];
        // 将尾部元素，移动到栈顶
        AlgUtil.swap(data,0,count-1);
        count--;
        heapifyDown();
        return max;
    }

    /**
     *  向下堆化：将堆顶元素与左右子节点进行比较，选出最大值，然后交换，交换之后，继续与左右子节点进行比较，选出最大值，选出这三个数之中得最大值，移动到顶部，依次类推
     */
    private void heapifyDown(){
        int i = 0;
        // 先假设栈顶元素就是最大值
        int max = i;
        while(i<count) {
            // 将栈顶元素与左边元素进行比较
            if (2 * i + 1<count && data[max] < data[2 * i + 1]) {
                max = 2 * i + 1;
            }
            // 将栈顶元素与右边元素进行比较
            if (2 * i + 2<count && data[max] < data[2 * i + 2]) {
                max = 2 * i + 2;
            }
            if (i != max) {
                AlgUtil.swap(data, i, max);
                // 移动更新位置
                i = max;
            }else {
                // 停止循环，说明已经是最大值
                break;
            }
        }
    }
}
