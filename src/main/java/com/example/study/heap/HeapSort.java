package com.example.study.heap;

import com.example.study.util.AlgUtil;
import org.junit.Test;

/**
 *  堆排序实现：原地排序
 */
public class HeapSort {

    @Test
    public void app() {
        int[] array = new int[]{0, 99, 2, 4, 3};
        // 构建最大堆:在尾部插入元素,依次和其父元素进行比较,然后依次相上调整
        for(int i=0;i<array.length;i++){
            int x = i;
            int parent = (x-1)/2;
            while (parent>=0 && array[parent]<array[i]){
                AlgUtil.swap(array,x,parent);
                // 更新x
                x = parent;
                // 更新parent
                parent = (x-1)/2;
            }
        }
        // 堆排序:取栈顶元素，将末尾元素放在这个位置然后剩余元素重新堆化,依次取栈顶元素，然后依次相下调整，其中栈顶元素依次放在末尾

        // 取栈顶元素,放到尾部
        for(int j =array.length-1;j>=0;j--){
            // 将栈顶元素放在末尾
            AlgUtil.swap(array,0, j);
            // 向下堆化：比较栈顶元素与左右子节点中得最大值,记录被交换的索引，然后继续向下堆化
            int i = 0;
            while (i<j){
                int max = i;
                int left = 2*i+1;
                int right = 2*i+2;
                if(left<j && array[left]>array[max]){
                    max = left;
                }
                if(right<j && array[right]>array[max]){
                    max = right;
                }
                if(max!=i){
                    AlgUtil.swap(array,i,max);
                    // 更新i的位置
                    i = max;
                }else {
                    break;
                }
            }
        }



        // 输出排序结果
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }




}
