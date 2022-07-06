package com.example.study.tree;

/**
 * leetcode-450
 * 二叉查找树：在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点值都大于这个节点的值
 */
public class BinarySearchTree {

    /**
     * 定义一个节点，作为二叉查找树的头
     */
    private Node tree;


    /**
     * 查找:从根节点依次比较data,小于节点data,往左遍历，相反往右遍历，依次类推
     *
     * @param data 查找的数据
     * @return
     */
    private Node find(int data) {
        // 遍历二叉查找树
        Node p = tree;
        while (p != null && data != p.data) {
            if (data < p.data) p = p.left;
            else p = p.right;
        }
        return p;
    }


    /**
     * 插入思路：只插入叶子节点先比较，再插入(直到找到叶子节点，再插入)
     *
     * @param data
     */
    private void insert(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {

                // 是叶子节点才可以插入
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                // 继续遍历
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    // 删除: 分为以下种情况：1、不存在，2、该节点没有子节点或该节点只有一个子节点，3、该节点有两个子节点，每次都要找右子树的最小值

    public void delete(int data) {
        // 指向要删除的节点
        Node p = tree;
        // pp指向p的父节点
        Node pp = null;

        /**
         * 定位需要删除的节点
         */
        while (p != null && data != p.data) {
            // 记录父节点
            pp = p;
            if (data < p.data) p = p.left;
            else p = p.right;
        }
        //没有找到,直接返回
        if (p == null) return;


        /**
         * 删除定位到的节点:1、有两个子节点 2、没有子节点或只有一个子节点
         */
        /**
         * 如果有两个子节点
         */
        if (p.left != null && p.right != null) {
            // 1、定位到右子树中最小的节点，为叶子节点（这是二叉搜索树的特性）
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minPP.left;
            }

            // 2、将p与minP交换位置
            p.data = minP.data;
            // 让p指向minP,此时的minP为叶子节点，然后删除的节点，就变为了没有子节点或只有一个子节点
            p = minP;
            pp = minPP;
        }


        /**
         *  如果没有节点或者仅有一个子节点
         */
        // 获取p的子节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        // 删除的是根节点
        if (pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

    }

    /**
     * 寻找最小节点
     *
     * @return
     */
    private Node findMin() {
        Node p = tree;
        while (p != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 寻找最大节点
     *
     * @return
     */
    private Node findMax() {
        Node p = tree;
        while (p != null) {
            p = p.right;
        }
        return p;
    }


    // 定义一个node
    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }
}
