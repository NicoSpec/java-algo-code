package com.tencent.code.readed;

/**
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 *
 * 注意：
 *
 * 满足编辑距离等于 1 有三种可能的情形：
 *
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 * 示例 1：
 *
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 示例 2:
 *
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 * 示例 3:
 *
 * 输入: s = "1203", t = "1213"
 * 输出: true
 * 解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EditDistance1 {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        // Ensure that s is shorter than t.
        if (ns > nt)
            return isOneEditDistance(t, s);

        // The strings are NOT one edit away distance
        // if the length diff is more than 1.
        if (nt - ns > 1)
            return false;

        for (int i = 0; i < ns; i++)
            if (s.charAt(i) != t.charAt(i))
                // if strings have the same length
                if (ns == nt)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                    // if strings have different lengths
                else
                    return s.substring(i).equals(t.substring(i + 1));

        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character.
        return ns != nt;
    }
}
