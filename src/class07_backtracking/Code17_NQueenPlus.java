package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code17_NQueenPlus {
    //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    //每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    public static List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];// i行的皇后放在了 record[i]位置
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(0, record, res, board);
        return res;
    }

    public static void backTracking(int index, int[] record, List<List<String>> res, char[][] board) {
        if (index == record.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < record.length; i++) {
            // 第index行放在i位置
            if (isValid(record, index, i)) {
                record[index] = i;
                board[index][i] = 'Q';
                backTracking(index + 1, record, res, board);
                board[index][i] = '.';
            }
        }
    }

    // 将棋盘转换为字符串列表
    public static List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
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
