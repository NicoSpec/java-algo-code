package cn.migu.music.easy;

/**
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @version 1.0 created by huangfei on 2025/1/10 15:15
 */
public class 最小覆盖子串 {

    /**
     *
     * 什么是「涵盖」
     * 看示例 1，s 的子串 BANC 中每个字母的出现次数，都大于等于 t=ABC 中每个字母的出现次数，这就叫涵盖。
     *
     * 滑动窗口怎么滑
     * 原理和 209 题一样，按照视频中的做法，我们枚举 s 子串的右端点 right（子串最后一个字母的下标），如果子串涵盖 t，就不断移动左端点 left 直到不涵盖为止。在移动过程中更新最短子串的左右端点。
     *
     * 具体来说：
     *
     * 初始化 ansLeft=−1, ansRight=m，用来记录最短子串的左右端点，其中 m 是 s 的长度。
     * 用一个哈希表（或者数组）cntT 统计 t 中每个字母的出现次数。
     * 初始化 left=0，以及一个空哈希表（或者数组）cntS，用来统计 s 子串中每个字母的出现次数。
     * 遍历 s，设当前枚举的子串右端点为 right，把 s[right] 的出现次数加一。
     * 遍历 cntS 中的每个字母及其出现次数，如果出现次数都大于等于 cntT 中的字母出现次数：
     * 如果 right−left<ansRight−ansLeft，说明我们找到了更短的子串，更新 ansLeft=left, ansRight=right。
     * 把 s[left] 的出现次数减一。
     * 左端点右移，即 left 加一。
     * 重复上述三步，直到 cntS 有字母的出现次数小于 cntT 中该字母的出现次数为止。
     * 最后，如果 ansLeft<0，说明没有找到符合要求的子串，返回空字符串，否则返回下标 ansLeft 到下标 ansRight 之间的子串。
     * 由于本题大写字母和小写字母都有，为了方便，代码实现时可以直接创建大小为 128 的数组，保证所有 ASCII 字符都可以统计。
     *
     * @param S
     * @param t
     * @return
     */
    public String minWindow(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[s[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[s[left]]--; // 左端点字母移出子串
                left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}