package class07_backtracking;

import class06_tree.tmp;

import java.util.ArrayList;
import java.util.List;

public class Code11_Permute {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public static void backTracking(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int val = nums[index];
        for (int i = index; i < nums.length; i++) {
            // 与开头交换
            swap(nums, index, i);
            path.add(nums[index]);
            backTracking(nums, index + 1);
            // 交换回来
            swap(nums, index, i);
            path.remove(path.size() - 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        permute(arr);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
