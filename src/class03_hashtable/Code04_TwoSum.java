package class03_hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class Code04_TwoSum {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出
    // 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
