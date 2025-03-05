package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code02_CombineSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        combineSum(9, n, k, res, path);
        return res;
    }

    private static void combineSum(int start, int target, int k, List<List<Integer>> res, List<Integer> path) {
        // 到头了 没选够
//        if (start == 0 && target != 0) {
//            return;
//        }
        if (target > (start + 1) * start / 2) {
            return;
        }
        // 和够了 且
        if (target <= 0) {
            if (k == 0 && target == 0) {
                res.add(new ArrayList<>(path));
            }
            //满足要求
            return;
        }
        path.add(start);
        combineSum(start - 1, target - start, k - 1, res, path);
        path.remove(path.size() - 1);
        combineSum(start - 1, target, k, res, path);
    }

    public static void main(String[] args) {

        List<List<Integer>> res = combinationSum3(4, 12);
        for (List<Integer> r : res) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
