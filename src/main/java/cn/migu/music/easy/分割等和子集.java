package cn.migu.music.easy;

import java.util.Arrays;

/**
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * @version 1.0 created by huangfei on 2025/2/8 15:16
 */
public class 分割等和子集 {

    /**
     * 设 nums 的元素和为 s。
     *
     * 两个子集的元素和相等，意味着：
     *
     * s 是偶数。
     * 子集元素和恰好等于
     * 2
     * s
     * ​
     *  。
     * 如果 s 是奇数，直接返回 false。
     *
     * 如果 s 是偶数，问题相当于：
     *
     * 能否从 nums 中选出一个子序列，其元素和恰好等于
     * 2
     * s
     * ​
     *  ？
     * 这可以用「恰好装满」型 0-1 背包解决，请看视频讲解：0-1 背包和完全背包【基础算法精讲 18】。制作不易，欢迎点赞关注~
     *
     * 二、记忆化搜索
     * 定义 dfs(i,j) 表示能否从 nums[0] 到 nums[i] 中选出一个和恰好等于 j 的子序列。
     *
     * 考虑 nums[i] 选或不选：
     *
     * 选：问题变成能否从 nums[0] 到 nums[i−1] 中选出一个和恰好等于 j−nums[i] 的子序列，即 dfs(i−1,j−nums[i])。
     * 不选：问题变成能否从 nums[0] 到 nums[i−1] 中选出一个和恰好等于 j 的子序列，即 dfs(i−1,j)。
     * 这两个只要有一个成立，dfs(i,j) 就是 true。所以有
     *
     * dfs(i,j)=dfs(i−1,j−nums[i])∨dfs(i−1,j)
     * 其中 ∨ 即编程语言中的 ||。代码实现时，可以只在 j≥nums[i] 时才调用 dfs(i−1,j−nums[i])，因为任何子序列的和都不会是负的。
     *
     * 递归边界：dfs(−1,0)=true, dfs(−1,>0)=false。
     *
     * 递归入口：dfs(n−1,s/2)，即答案。
     *
     */
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int[][] memo = new int[n][s / 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, s / 2, nums, memo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] memo) {
        if (i < 0) {
            return j == 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j] == 1;
        }
        boolean res = j >= nums[i] && dfs(i - 1, j - nums[i], nums, memo) || dfs(i - 1, j, nums, memo);
        memo[i][j] = res ? 1 : 0; // 记忆化
        return res;
    }
}

