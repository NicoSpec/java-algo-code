package cn.migu.music.easy;

import common.ListNode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * @version 1.0 created by huangfei on 2025/1/14 14:02
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        // 创建虚节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 每一组的前缀节点
        ListNode preGroup = dummy;
        while(true){
            // 每一组的开始节点
            ListNode start = preGroup.next;
            // 获取每一组的结束节点
            ListNode end = start;
            for(int i = 0; i < k - 1 && end != null; i++){
                end = end.next;
            }
            // 如果不足k个节点，则停止
            if(end == null) break;
            // 记录下一组的开始节点
            ListNode nextStart = end.next;
            // 断裂与下一组的连接
            end.next = null;
            // 反转当前组
            ListNode currGroup =  reverse(start);
            // 将当前组与前缀节点连接
            preGroup.next = currGroup;
            // 连接下一组，start已经变为end
            start.next = nextStart;
            // 更新下一组的前缀节点
            preGroup = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }






















    public static ListNode reverseKGroup1(ListNode head, int k) {

        ListNode dump = new ListNode();
        dump.next = head;

        ListNode preGroup = dump;
        ListNode cur = preGroup;

        while (true) {
            int i = 0;
            for (;i < k && cur != null;i++) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            ListNode nextPreGroup = cur.next;
            cur.next = null;
            ListNode node = reverse1(preGroup.next);
            ListNode end = preGroup.next;
            preGroup.next = node;
            end.next = nextPreGroup;

            preGroup = end;
            cur = preGroup;

        }


        return dump.next;
    }


    public static ListNode reverse1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        ListNode head2 = new ListNode(3);
        head1.next = head2;
        ListNode hea3 = new ListNode(4);
        head2.next = hea3;
        ListNode hea4 = new ListNode(5);
        hea3.next = hea4;
        ListNode hea5 = new ListNode(6);
        hea4.next = hea5;
        ListNode hea6 = new ListNode(7);
        hea5.next = hea6;
        ListNode hea7 = new ListNode(8);
        hea6.next = hea7;
        ListNode head8 = new ListNode(9);
        hea7.next = head8;
        ListNode head9 = new ListNode(10);
        head8.next = head9;
        ListNode head10 = new ListNode(11);
        head9.next = head10;
        ListNode head11 = new ListNode(12);
        head10.next = head11;
        ListNode head12 = new ListNode(13);
        head11.next = head12;
        ListNode head13 = new ListNode(14);
        head12.next = head13;
        head13.next = null;

        ListNode node = reverseKGroup1(head, 3);

        ListNode tmp = node;

        while (tmp != null) {
            System.out.println(tmp.getVal());
            tmp = tmp.next;
        }
    }
}

