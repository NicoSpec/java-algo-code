package com.tencent.code.readed;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionLinked {
    private static class ListNode {
        ListNode next;
        int val;

        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode insertionSortList(ListNode head) {

        if (head == null && head.next == null) {
            return head;
        }
        //哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //pre负责指向新元素，last 负责指向新元素的前一元素
        //判断是否需要执行插入操作
        ListNode pre = head.next;
        ListNode last = head;
        ListNode temphead = dummyNode;
        while (pre != null) {
            //不需要插入到合适位置，则继续往下移动
            if (last.val <= pre.val) {
                pre = pre.next;
                last = last.next;
                continue;
            }
            //开始出发，查找新元素的合适位置
            temphead = dummyNode;
            while (temphead.next.val <= pre.val) {
                temphead = temphead.next;
            }
            //此时我们已经找到了合适位置，我们需要进行插入，大家可以画一画
            last.next = pre.next;
            pre.next = temphead.next;
            temphead.next = pre;
            pre = last.next;
        }
        return dummyNode.next;

    }
}
