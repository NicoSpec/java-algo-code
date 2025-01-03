package cn.migu.music.easy.case20250102;

import java.util.HashMap;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @version 1.0 created by huangfei on 2025/1/2 18:17
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2)
            return false;
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        for (int i = 0; i < len1; i++) {
            dic.put(s.charAt(i) , dic.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            dic.put(t.charAt(i) , dic.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int val : dic.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}
