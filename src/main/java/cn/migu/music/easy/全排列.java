package cn.migu.music.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @version 1.0 created by huangfei on 2025/1/20 10:24
 */
public class 全排列 {
    List<Integer> nums;
    List<List<Integer>> res;

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(nums);  // 添加排列方案
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            //这个交换是用nums[i]固定第x位，但是他也会把当前x位的放在第i位（i>=x），这样的话，就形成一种排序； 假设此时i=x+1，也就是这次swap
            // 是把第x+1位的元素固定在第x位上，第x位上的跑去了第x+1位； 之后再固定第x+1位的时候，会用第x+2位来进行swap，这样就有形成一种排列；
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    /**
     *
     * 递归解析：
     * 终止条件： 当 x = len(nums) - 1 时，代表所有位已固定（最后一位只有 1 种情况），则将当前组合 nums 转化为数组并加入 res ，并返回。
     * 递推参数： 当前固定位 x 。
     * 递推工作： 将第 x 位元素与 i ∈ [x, len(nums)] 元素分别交换，并进入下层递归。
     * 固定元素： 将元素 nums[i] 和 nums[x] 交换，即固定 nums[i] 为当前位元素。
     * 开启下层递归： 调用 dfs(x + 1) ，即开始固定第 x + 1 个元素。
     * 还原交换： 将元素 nums[i] 和 nums[x] 交换（还原之前的交换）。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<List<Integer>>();
        this.nums = new ArrayList<Integer>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }
}
