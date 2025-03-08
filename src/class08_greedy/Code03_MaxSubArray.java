package class08_greedy;

public class Code03_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            res = Math.max(cur, res);
            if (cur < 0) {
                cur = 0;
            }

        }
        return res;
    }
}
