package class08_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Code12_EraseOverlapIntervals {
    // 无重叠区间
    public static int eraseOverlapIntervals(int[][] intervals) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int rightBorder = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < rightBorder) {
                // 相交
                res++;
                if (intervals[i][1] < rightBorder) {
                    rightBorder = intervals[i][1];
                }
            } else {
                rightBorder = intervals[i][1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] arr = {
//                {1, 2}, {2, 3}, {3, 4}, {1, 3}
//                {1, 2}, {1, 2}, {1, 2}
                {-52, 31},
                {-73, -26},
                {82, 97},
                {-65, -11},
                {-62, -49},
                {95, 99},
                {58, 95},
                {-31, 49},
                {66, 98},
                {-63, 2},
                {30, 47},
                {-40, -26}
        };
        System.out.println(eraseOverlapIntervals(arr));
    }
}
