package cn.migu.music.easy;

import common.TreeNode;

/**
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * @version 1.0 created by huangfei on 2025/1/16 16:46
 */
public class 二叉树中的最大路径和 {
    private int maxSum = Integer.MIN_VALUE; // 记录全局最大路径和

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 空节点贡献值为0
        }

        // 计算左右子树的最大贡献值（负数置为0）
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // 更新最大路径和：当前节点 + 左子树贡献 + 右子树贡献
        maxSum = Math.max(maxSum, node.val + left + right);

        // 返回当前节点的最大单向贡献值
        return node.val + Math.max(left, right);
    }
}