package cn.migu.music.easy.case2024;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * @version 1.0 created by huangfei on 2024/12/30 14:46
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rex = 0;
        int y = x;
        while (x / 10 != 0) {
            int pop = x % 10;
            x /= 10;
            rex = rex * 10 + pop;
        }
        rex = rex * 10 + x;
        if (rex != y) {
            return false;
        }

        return true;
    }
}
