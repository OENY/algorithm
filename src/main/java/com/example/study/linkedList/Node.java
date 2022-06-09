package com.example.study.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yuanchenglong
 * @Description: 节点
 * @Date: 2022/6/9 11:18
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    /**
     * 数据域
     */
    Integer data;
    /**
     * 指针域
     */
    Node next;
}
