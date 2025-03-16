package class07_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code14_GPTPermute {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 排序确保相同元素相邻，方便去重
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    public static void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已使用或与前一个相同且前一个未使用，跳过，避免重复排列
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }
}
