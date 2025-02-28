package class01_array;

import java.util.Scanner;

/*
在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，
代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，
而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，
使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
注意：区块不可再
 */
public class Code07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        row = sc.nextInt();
        col = sc.nextInt();
        int sum = 0;
        int[] colSum = new int[col];
        int[] rowSum = new int[row];
        int val;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                val = sc.nextInt();
                colSum[j] += val;
                rowSum[i] += val;
                sum += val;
            }
        }
        // 计算前缀和
        for (int i = 1; i < row; i++) {
            rowSum[i] += rowSum[i - 1];
        }
        for (int i = 1; i < col; i++) {
            colSum[i] += colSum[i - 1];
        }
        // 计算结果
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row - 1; i++) {
            res = Math.min(res, Math.abs(sum - 2 * rowSum[i]));
        }
        for (int i = 0; i < col - 1; i++) {
            res = Math.min(res, Math.abs(sum - 2 * colSum[i]));

        }
        System.out.println(res);
    }
}
