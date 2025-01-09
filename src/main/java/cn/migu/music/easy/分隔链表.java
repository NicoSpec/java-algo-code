package cn.migu.music.easy;

import common.ListNode;

/**
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * @version 1.0 created by huangfei on 2025/1/7 18:25
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode smlDummy = new ListNode(), bigDummy = new ListNode();
        ListNode sml = smlDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        sml.next = bigDummy.next;
        big.next = null;
        return smlDummy.next;
    }
}