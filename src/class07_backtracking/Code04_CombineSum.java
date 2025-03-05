package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code04_CombineSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target < 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        combinationSum(0, candidates, target, res, path);
        return res;
    }

    public static void combinationSum(int index, int[] candidates, int target, List<List<Integer>> res, List<Integer> path) {
        //
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = 0; i <= target / candidates[index]; i++) {
            for (int j = 0; j < i; j++) {
                path.add(candidates[index]);
            }
            combinationSum(index + 1, candidates, target - i * candidates[index], res, path);
            for (int j = 0; j < i; j++) {
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] can = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(can, 7);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
