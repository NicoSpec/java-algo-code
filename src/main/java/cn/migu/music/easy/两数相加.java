package cn.migu.music.easy;

import common.ListNode;
import org.junit.Test;

/**
 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

  

 示例 1：


 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.
 示例 2：

 输入：l1 = [0], l2 = [0]
 输出：[0]
 示例 3：

 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]
  

 提示：

 每个链表中的节点数在范围 [1, 100] 内
 0 <= Node.val <= 9
 题目数据保证列表表示的数字不含前导零

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数相加 {

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode();
        l1.setVal(9);
        ListNode l11 = new ListNode();
        l11.setVal(2);
        l1.setNext(l11);
        ListNode l12 = new ListNode();
        l12.setVal(7);
        l11.setNext(l12);

        ListNode l2 = new ListNode();
        l2.setVal(1);
        ListNode l21 = new ListNode();
        l21.setVal(2);
        l2.setNext(l21);
        ListNode l22 = new ListNode();
        l22.setVal(3);
        l21.setNext(l22);

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        int sum = 0;
        ListNode node = new ListNode();
        ListNode head = node;
        ListNode pre = node;
        while (l1 != null && l2 != null) {
            int curVal = l1.getVal() + l2.getVal() + sum;
            node.setVal(curVal % 10);
            sum = curVal / 10;
            l1 = l1.getNext();
            l2 = l2.getNext();
            pre = node;
            node.setNext(new ListNode());
            node = node.getNext();
        }

        while (l1 != null) {
            int curVal = l1.getVal() + sum;
            node.setVal(curVal % 10);
            sum = curVal / 10;
            l1 = l1.getNext();
            pre = node;
            node.setNext(new ListNode());
            node = node.getNext();

        }

        while (l2 != null) {
            int curVal = l2.getVal() + sum;
            node.setVal(curVal % 10);
            sum = curVal / 10;
            l2 = l2.getNext();
            pre = node;
            node.setNext(new ListNode());
            node = node.getNext();
        }
        if (sum != 0) {
            node.setVal(sum);
        }else {
            pre.setNext(null);
        }
        return head;
    }
}
