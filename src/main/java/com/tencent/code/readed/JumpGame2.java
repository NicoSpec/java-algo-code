package com.tencent.code.readed;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到maxPosition位置的点）作为下次的起跳点 ！
public class JumpGame2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;                    // 上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPosition = 0;            // 目前能跳到的最远位置
        int steps = 0;                  // 跳跃次数
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end) {
                end = maxPosition;      // 目前能跳到的最远位置变成了下次起跳位置的有边界
                steps++;                // 进入下一次跳跃
            }
        }
        return steps;
    }
}
