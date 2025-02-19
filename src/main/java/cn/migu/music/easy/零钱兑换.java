package cn.migu.music.easy;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @version 1.0 created by huangfei on 2025/2/7 23:00
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0){
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1);
                }
            }
        }

        return memo[amount] == (amount+1) ? -1 : memo[amount];
    }
}

