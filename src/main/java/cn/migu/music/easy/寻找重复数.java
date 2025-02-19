package cn.migu.music.easy;

/**
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3 :
 *
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 *
 * @version 1.0 created by huangfei on 2025/2/8 22:31
 */
public class 寻找重复数 {

    /**
     *
     * 可以使用 Floyd 的龟兔赛跑算法（快慢指针法） 来解决这个问题。该算法的核心思想是将数组视为链表，其中每个索引 i 指向 nums[i] 作为下一个节点。由于数字范围在 [1, n] 之间，而数组长度为 n+1，根据 抽屉原理，至少存在一个重复的数字，因此链表中必然存在环。
     *
     * 解法思路
     * 使用快慢指针寻找环内相遇点
     *
     * 设定两个指针，slow 和 fast，初始位置都在 nums[0]。
     * slow 每次走一步：slow = nums[slow]
     * fast 每次走两步：fast = nums[nums[fast]]
     * 当 slow == fast 时，说明存在环。
     * 寻找环的入口
     *
     * 重新设定 slow 回到起点 nums[0]，而 fast 保持在相遇点。
     * slow 和 fast 以相同速度（每次走一步）继续移动，直到它们相遇。
     * 相遇点即为重复的数。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // 第一步：使用快慢指针寻找相遇点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 第二步：重新设定慢指针，寻找环的入口（即重复的数）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // 返回重复的数
    }
}


