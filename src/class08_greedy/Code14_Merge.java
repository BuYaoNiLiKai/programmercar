package class08_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Code14_Merge {
    //以数组 intervals 表示若干个区间的集合，其中单个区间为
    // intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
    // 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    //示例 1：
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2：

    //输入：intervals = [[1,4],[4,5]]
    //输出：[[1,5]]
    //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int leftBorder = intervals[0][0];
        int rightBorder = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= rightBorder) {
                rightBorder = Math.max(rightBorder, intervals[i][1]);
            } else {
                res.add(new int[]{leftBorder, rightBorder});
                leftBorder = intervals[i][0];
                rightBorder = intervals[i][1];
            }
        }
        res.add(new int[]{leftBorder, rightBorder});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3,}, {2, 6,}, {8, 10}, {15, 18}
//                {1, 4}, {4, 5}
        };
        int[][] res = merge(arr);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
