package class01_array;

public class Code03 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;

        }
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
