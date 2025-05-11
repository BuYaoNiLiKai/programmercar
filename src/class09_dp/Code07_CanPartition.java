package class09_dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class Code07_CanPartition {
    //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    //示例 1：
    //输入：nums = [1,5,11,5]
    //输出：true
    //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    //示例 2：
    //输入：nums = [1,2,3,5]
    //输出：false
    //解释：数组不能分割成两个元素和相等的子集。
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        return f(nums, 0, target);
    }

    public boolean f(int[] nums, int index, int tagret) {
        if (tagret == 0) {
            return true;
        }
        if (index == nums.length || tagret < 0) {
            return false;
        }
        // 数组nums中 能否找到和为targer的目标
        return f(nums, index + 1, tagret - nums[index]) || f(nums, index + 1, tagret);
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
