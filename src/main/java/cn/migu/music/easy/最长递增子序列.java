package cn.migu.music.easy;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * @version 1.0 created by huangfei on 2025/2/8 14:30
 */
public class 最长递增子序列 {

    /**
     *
     * 解法一：动态规划
     * 解题思路：
     * 状态定义：
     *
     * dp[i] 的值代表 nums 以 nums[i] 结尾的最长子序列长度。
     * 转移方程： 设 j∈[0,i)，考虑每轮计算新 dp[i] 时，遍历 [0,i) 列表区间，做以下判断：
     *
     * 当 nums[i]>nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j]+1 ；
     * 当 nums[i]<=nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列不成立，跳过。
     * 上述所有 1. 情况 下计算出的 dp[j]+1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i] ）。实现方式为遍历 j 时，每轮执行 dp[i]=max(dp[i],dp[j]+1)。
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     * 初始状态：
     *
     * dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
     * 返回值：
     *
     * 返回 dp 列表最大值，即可得到全局最长上升子序列长度。
     * 复杂度分析：
     * 时间复杂度 O(N
     * 2
     *  ) ： 遍历计算 dp 列表需 O(N)，计算每个 dp[i] 需 O(N)。
     * 空间复杂度 O(N) ： dp 列表占用线性大小额外空间。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}


