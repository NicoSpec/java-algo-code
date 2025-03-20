package cn.migu.music.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0 created by huangfei on 2025/3/13 21:19
 */
public class 二叉树中和为目标值的路径 {
}


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    public List<List<Integer>> pathTarget(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum) {
        if (node == null) {
            return;
        }
        // 将当前节点的值添加到路径中
        currentPath.add(node.val);

        // 如果是叶子节点且剩余值等于当前节点的值
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath)); // 记录当前路径
        }

        // 递归遍历左子树和右子树
        dfs(node.left, remainingSum - node.val);
        dfs(node.right, remainingSum - node.val);

        // 回溯，移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public boolean isSubsequence(String s, String t) {
        int pre = 0;
        int next = 0;
        while(pre < s.length() && next < t.length()) {
            if(s.charAt(pre) == t.charAt(next)) {
                pre++;next++;
            } else {
                next++;
            }
        }
        return pre == s.length();
    }
}