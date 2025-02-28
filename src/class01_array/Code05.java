package class01_array;

public class Code05 {
    /*
    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
    且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     */
    public static int setBorder(int[][] arr, int l, int r, int val) {
        //设置左上到右下的边框
        // lr lc 左上的行列坐标
        // rr rc 右下的坐标
        if (l == r) {
            arr[l][r] = val++;
            return val;
        }
        for (int i = l; i < r; i++) {
            arr[l][i] = val++;
        }
        for (int i = l; i < r; i++) {
            arr[i][r] = val++;
        }
        for (int i = r; i > l; i--) {
            arr[r][i] = val++;
        }
        for (int i = r; i > l; i--) {
            arr[i][l] = val++;
        }
        return val;

    }

    static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int j = n - 1;
        int val = 1;
        while (i <= j) {
            val = setBorder(res, i, j, val);
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(5);
        print2dArray(res);
    }
}
