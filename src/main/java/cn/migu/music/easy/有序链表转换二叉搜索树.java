package cn.migu.music.easy;

import common.ListNode;
import common.TreeNode;

/**
 *
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为
 * 平衡
 *  二叉搜索树。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 *
 * 输入: head = []
 * 输出: []
 *
 * @version 1.0 created by huangfei on 2025/1/8 16:15
 */
public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}