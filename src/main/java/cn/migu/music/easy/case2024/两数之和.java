package cn.migu.music.easy.case2024;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

 你可以按任意顺序返回答案。

  

 示例 1：

 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 示例 2：

 输入：nums = [3,2,4], target = 6
 输出：[1,2]
 示例 3：

 输入：nums = [3,3], target = 6
 输出：[0,1]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数之和 {

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{3,2,4};
        int[] ints = twoSum(nums, 6);
        if (ints != null) {
            for (int i :  ints) {
                System.out.println(i);
            }
        }

    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> hashTable = Maps.newHashMap();
        for (int i = 0;i < nums.length;i++){
            if (hashTable.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hashTable.get(target - nums[i]);
                return res;
            }else {
                hashTable.put(nums[i], i);
            }
        }

        return null;
    }
}
