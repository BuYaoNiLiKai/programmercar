package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code05_CombinationSum {
    //给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    //candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        combinationSum(0, candidates, target, path);
        return res;

    }

    public void combinationSum(int index, int[] candidates, int target, List<Integer> path) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (index == candidates.length) {
            return;
        }
        int round = target / candidates[index];
        for (int i = 0; i <= round; i++) {
            for (int j = 0; j < i; j++) {
                path.add(candidates[index]);
            }
            combinationSum(index + 1, candidates, target - i * candidates[index], path);
            for (int j = 0; j < i; j++) {
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Code05_CombinationSum code05CombinationSum = new Code05_CombinationSum();
        int[] arr = {2, 3, 5};
        List<List<Integer>> result = code05CombinationSum.combinationSum(arr, 8);
        for (List<Integer> l : result) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
