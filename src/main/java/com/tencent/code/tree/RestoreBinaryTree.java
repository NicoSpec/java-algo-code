package com.tencent.code.tree;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 *
 *
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *  
 *
 * 提示：
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *  
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreBinaryTree {
}