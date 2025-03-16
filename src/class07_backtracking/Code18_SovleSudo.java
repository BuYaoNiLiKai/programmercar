package class07_backtracking;

import java.util.ArrayList;

public class Code18_SovleSudo {
    static class Index {
        public int row;
        public int col;

        public Index(int r, int c) {
            row = r;
            col = c;
        }
    }

    public void solveSudoku(char[][] board) {
        // 先把所有的空白格记录到rowindex和 colindex中
        // 出现的次数
        int n = board.length;
        ArrayList<Index> space = new ArrayList<>();// 空白位置
        int[] record = new int[9];//
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    record[board[i][j] - '0']++;
                } else {
                    space.add(new Index(i, j));
                }
            }
        }

    }

    public void backTracking(char[][] board, ArrayList<Index> space, int index) {
        if (index == space.size()) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            board[space.get(index).row][space.get(index).row] = (char) ('0' + i);

        }

    }

    public static void main(String[] args) {

    }
}
