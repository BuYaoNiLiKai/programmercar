package class08_greedy;

import java.util.Arrays;

public class Code06_LargestSumAfterKNegations {
    //给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
    //选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
    //重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
    //以这种方式修改数组后，返回数组 可能的最大和 。
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // 在k的范围内反转负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 重新排序 让第一个是最小值
        Arrays.sort(nums);
        int max = 0;
        // 如果k仍然大于0
        if (k % 2 == 1) nums[0] = -nums[0];
        // 累加
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
