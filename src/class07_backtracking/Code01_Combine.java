package class07_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code01_Combine {
    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    //你可以按 任何顺序 返回答案。

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        combine(n, k, res, path);
        return res;
    }

    public static void combine(int n, int k, List<List<Integer>> res, List<Integer> path) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (n < k) {
            return;
        }
        // 要和不要
        path.add(n);
        combine(n - 1, k - 1, res, path);
        path.remove(path.size() - 1);
        combine(n - 1, k, res, path);

    }

    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        combineHelper(n, k, 1, result, path);
        return result;
    }

    private static void combineHelper(int n, int k, int startIndex, List<List<Integer>> result, LinkedList<Integer> path) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n, k, i + 1, result, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        // 对比速度
        int n = 4;
        int k = 2;
        long time = System.currentTimeMillis();

        List<List<Integer>> res = combine(n, k);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
