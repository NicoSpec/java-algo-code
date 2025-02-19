package cn.migu.music.easy;

/**
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * @version 1.0 created by huangfei on 2025/2/8 17:22
 */
public class 最长公共子序列 {

    /**
     *
     * 最长公共子序列问题是典型的二维动态规划问题。
     *
     * 假设字符串 text
     * 1
     * ​
     *   和 text
     * 2
     * ​
     *   的长度分别为 m 和 n，创建 m+1 行 n+1 列的二维数组 dp，其中 dp[i][j] 表示 text
     * 1
     * ​
     *  [0:i] 和 text
     * 2
     * ​
     *  [0:j] 的最长公共子序列的长度。
     *
     * 上述表示中，text
     * 1
     * ​
     *  [0:i] 表示 text
     * 1
     * ​
     *   的长度为 i 的前缀，text
     * 2
     * ​
     *  [0:j] 表示 text
     * 2
     * ​
     *   的长度为 j 的前缀。
     *
     * 考虑动态规划的边界情况：
     *
     * 当 i=0 时，text
     * 1
     * ​
     *  [0:i] 为空，空字符串和任何字符串的最长公共子序列的长度都是 0，因此对任意 0≤j≤n，有 dp[0][j]=0；
     *
     * 当 j=0 时，text
     * 2
     * ​
     *  [0:j] 为空，同理可得，对任意 0≤i≤m，有 dp[i][0]=0。
     *
     * 因此动态规划的边界情况是：当 i=0 或 j=0 时，dp[i][j]=0。
     *
     * 当 i>0 且 j>0 时，考虑 dp[i][j] 的计算：
     *
     * 当 text
     * 1
     * ​
     *  [i−1]=text
     * 2
     * ​
     *  [j−1] 时，将这两个相同的字符称为公共字符，考虑 text
     * 1
     * ​
     *  [0:i−1] 和 text
     * 2
     * ​
     *  [0:j−1] 的最长公共子序列，再增加一个字符（即公共字符）即可得到 text
     * 1
     * ​
     *  [0:i] 和 text
     * 2
     * ​
     *  [0:j] 的最长公共子序列，因此 dp[i][j]=dp[i−1][j−1]+1。
     *
     * 当 text
     * 1
     * ​
     *  [i−1]
     * 
     * =text
     * 2
     * ​
     *  [j−1] 时，考虑以下两项：
     *
     * text
     * 1
     * ​
     *  [0:i−1] 和 text
     * 2
     * ​
     *  [0:j] 的最长公共子序列；
     *
     * text
     * 1
     * ​
     *  [0:i] 和 text
     * 2
     * ​
     *  [0:j−1] 的最长公共子序列。
     *
     * 要得到 text
     * 1
     * ​
     *  [0:i] 和 text
     * 2
     * ​
     *  [0:j] 的最长公共子序列，应取两项中的长度较大的一项，因此 dp[i][j]=max(dp[i−1][j],dp[i][j−1])。
     *
     * 由此可以得到如下状态转移方程：
     *
     * dp[i][j]={
     * dp[i−1][j−1]+1,
     * max(dp[i−1][j],dp[i][j−1]),
     * ​
     *
     * text
     * 1
     * ​
     *  [i−1]=text
     * 2
     * ​
     *  [j−1]
     * text
     * 1
     * ​
     *  [i−1]
     * 
     * =text
     * 2
     * ​
     *  [j−1]
     * ​
     *
     * 最终计算得到 dp[m][n] 即为 text
     * 1
     * ​
     *   和 text
     * 2
     * ​
     *   的最长公共子序列的长度。
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
