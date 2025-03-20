package cn.migu.music.easy;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * 给定一个只包含数字的字符串 s，返回所有可能的有效 IP 地址组合。你可以以任何顺序返回这些组合。
 *
 * 有效 IP 地址 由四个部分组成，每个部分是一个 0 到 255 之间的整数，且不能有前导零（除非该部分本身就是 0）。
 *
 * @version 1.0 created by huangfei on 2025/3/20 10:57
 */
public class 复原IP {

    /**
     * 这道题的核心是通过 ​回溯算法 来遍历所有可能的分割方式，并检查每个部分是否合法。具体步骤如下：
     *
     * 从字符串的开头开始，尝试取 1 到 3 个字符作为 IP 地址的一个部分。
     * 检查当前部分是否合法（0 到 255 之间，且没有前导零）。
     * 如果合法，递归处理剩余字符串，直到找到 4 个合法部分。
     * 如果找到 4 个合法部分且字符串被完全使用，则记录结果。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result; // 如果字符串长度不合法，直接返回空列表
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // 如果已经找到4个部分且遍历完所有字符，记录结果
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // 尝试从当前索引开始，取1到3个字符作为下一个部分
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break; // 如果超出字符串长度，直接退出
            }
            String segment = s.substring(index, index + i);
            if (isValid(segment)) {
                path.add(segment); // 添加当前部分
                backtrack(s, index + i, path, result); // 递归处理剩余部分
                path.remove(path.size() - 1); // 回溯，移除当前部分
            }
        }
    }

    private boolean isValid(String segment) {
        // 检查部分是否合法：长度大于1时不能有前导零，且数值在0到255之间
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false; // 前导零不合法
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}
