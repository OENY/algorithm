package com.example.study.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {


    List<List<Integer>> list = new ArrayList<>();

    /**
     * 层序遍历-DFS 度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        if (root == null) return list;
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode root, int level) {
        // 递归结束条件
        if (root == null) return;
        // 往指定层级设置值
        if (list.size() == level) list.add(new ArrayList<>()); // 空间不够,申请空间
        list.get(level).add(root.val);

        // 递归体
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);

    }


    /**
     * 利用队列实现，offer and poll
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 入队
        queue.offer(root);

        // 不断循环
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                // 出队
                TreeNode node = queue.poll();

                // 记录
                level.add(node.val);

                // 依次将左右子节点入队，顺序先left then right
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }

            // 记录:level是按顺讯的
            ret.add(level);
        }

        return ret;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
