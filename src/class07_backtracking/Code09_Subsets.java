package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code09_Subsets {
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtracing(nums, 0);
        return res;
    }

    public static void backtracing(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtracing(nums, index + 1);
        path.remove(path.size() - 1);
        backtracing(nums, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        subsets(arr);
        for (List<Integer> l : res) {
            System.out.println(l);
        }

    }
}
