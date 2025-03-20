package cn.migu.music.easy;

import common.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * @version 1.0 created by huangfei on 2025/1/16 14:11
 */
public class 二叉树的最近公共祖先 {

    /**
     * 递归解析：
     * 终止条件：
     * 当越过叶节点，则直接返回 null ；
     * 当 root 等于 p,q ，则直接返回 root ；
     * 递推工作：
     * 开启递归左子节点，返回值记为 left ；
     * 开启递归右子节点，返回值记为 right ；
     * 返回值： 根据 left 和 right ，可展开为四种情况；
     * 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     * 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     * p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     * p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        // 左右都不是空说明p和q在root的左子树和右子树各一个
        return root;
    }
}