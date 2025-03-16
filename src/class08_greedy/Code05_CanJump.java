package class08_greedy;

public class Code05_CanJump {
    public boolean canJump(int[] nums) {
        int reachIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            reachIndex = i + nums[i] >= reachIndex ? i : reachIndex;
        }
        return reachIndex == 0;
    }

    //给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
    //每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
    //0 <= j <= nums[i]
    //i + j < n
    //返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
    public static int jump(int[] nums) {
        int result = 0;
        // 当前覆盖的最远距离下标
        int end = 0;
        // 下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; ++i) {
            temp = Math.max(temp, i + nums[i]);
            // 可达位置的改变次数就是跳跃次数
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 1, 4};
        System.out.println(jump(arr));
    }
}
