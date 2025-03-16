package class07_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code13_PermutePlus {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public static void backTracking(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // 与开头交换
            swap(nums, index, i);
            if (set.isEmpty() || !set.contains(nums[index])) {
                set.add(nums[index]);
                path.add(nums[index]);
                backTracking(nums, index + 1);
                // 交换回来
                path.remove(path.size() - 1);
            }
            swap(nums, index, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        permuteUnique(arr);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
