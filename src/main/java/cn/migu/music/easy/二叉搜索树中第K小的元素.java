package cn.migu.music.easy;

import common.TreeNode;

/**
 * @version 1.0 created by huangfei on 2025/1/15 14:42
 */
public class 二叉搜索树中第K小的元素 {
    private int res, k;
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
}
