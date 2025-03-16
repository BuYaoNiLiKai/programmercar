package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code16_NQueen {
    //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    //每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    public static List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];// i行的皇后放在了 record[i]位置
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(0, record, res, path);
        return res;
    }

    public static void backTracking(int index, int[] record, List<List<String>> res, List<String> path) {
        if (index == record.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < record.length; i++) {
            // 第index行放在i位置
            if (isValid(record, index, i)) {
                record[index] = i;
                path.add(getString(i, record.length));
                backTracking(index + 1, record, res, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static String getString(int col, int n) {
        // Q放在第几列
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            if (i == col) {
                arr[i] = 'Q';
            } else {
                arr[i] = '.';
            }
        }
        return new String(arr);
    }

    public static boolean isValid(int[] record, int row, int col) {
        // 前row-1行已经放好了
        for (int i = 0; i < row; i++) {
            if (record[i] == col || Math.abs(record[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res);
    }
}
