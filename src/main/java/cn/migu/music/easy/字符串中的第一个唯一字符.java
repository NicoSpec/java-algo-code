package cn.migu.music.easy;

import java.util.HashMap;

/**
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * @version 1.0 created by huangfei on 2025/1/7 11:21
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<Character, Boolean>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(int i = 0; i < sc.length; i++)
            if(dic.get(sc[i])) return i;
        return -1;
    }
}