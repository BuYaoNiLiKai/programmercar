package class05_qs;

import java.util.LinkedList;

public class Code06_SlidingWindow {
    //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

    //返回 滑动窗口中的最大值
    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    //解释：
    //滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 没有
        if (nums == null || nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> window = new LinkedList<>();// 滑动窗口
        //滑动窗口 存储的是下标。并且 下标对应的元素 first->last 单调递减
        for (int i = 0; i < nums.length; i++) {
            // 找到插入位置 =号为了更新下标
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            //插入
            window.addLast(i);
            //弹出过期节点
            if (window.peekFirst() == i - k) {
                window.pollFirst();
            }

            if (i >= k - 1) {
                res[index++] = nums[window.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(arr, 3);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
}
