package class01_array;

public class Code04 {
    /*
    给定一个含有 n 个正整数的数组和一个正整数 target 。
    找出该数组中满足其总和大于等于 target 的长度最小的
    子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
    并返回其长度。如果不存在符合条件的子数组，返回 0
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int head = 0;
        int tail = 0;
        while (tail < nums.length) {
            sum += nums[tail];
            while (sum >= target) {
                res = Math.min(res, tail - head + 1);
                sum -= nums[head];
                head++;
            }
            tail++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(7, arr);
        System.out.println(res);
    }
}
