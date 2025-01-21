package cn.migu.music.easy;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * @version 1.0 created by huangfei on 2025/1/16 11:12
 */
public class 路径总和III {
    private int ans;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<Long, Integer>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        s += node.val;
        ans += cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum);
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // 恢复现场
    }
}