package class07_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code10_FindSubsequences {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private static void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2)
            result.add(new ArrayList<>(path));
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || hs.contains(nums[i]))
                continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 7};
        findSubsequences(arr);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }
}
