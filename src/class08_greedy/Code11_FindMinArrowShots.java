package class08_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Code11_FindMinArrowShots {
    //有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
    // 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
    //一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
    // 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
    // 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
    //给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
    //示例 1：
    //输入：points = [[10,16],[2,8],[1,6],[7,12]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //-在x = 6处射出箭，击破气球[2,8]和[1,6]。
    //-在x = 11处发射箭，击破气球[10,16]和[7,12]。
    //示例 2：
    //输入：points = [[1,2],[3,4],[5,6],[7,8]]
    //输出：4
    //解释：每个气球需要射出一支箭，总共需要4支箭。
    //示例 3：okjb
    //输入：points = [[1,2],[2,3],[3,4],[4,5]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
    //- 在x = 4处射出箭，击破气球[3,4]和[4,5]
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
//        int leftBorder = points[0][0];
        int rightBorder = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
//            if (points[i][0] > nowEnd) {
//                res++;
//                nowEnd = points[i][1];
//            }
            if (points[i][0] > rightBorder) {
//                leftBorder = points[i][0];
                rightBorder = points[i][1];
                res++;
            } else {
//                leftBorder = Math.min(leftBorder, points[i][0]);
                rightBorder = Math.min(rightBorder, points[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {
//                {10, 16},
//                {2, 8}, {1, 6}, {7, 12}
//                {1, 2},
//                {3, 4},
//                {5, 6}, {7, 8}
                {9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}
        };
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            return a[0] - b[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });
        for (int[] row : points) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(findMinArrowShots(points));
    }
}
