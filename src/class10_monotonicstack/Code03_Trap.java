package class10_monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

// 接雨水
public class Code03_Trap {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出：6
    //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    //示例 2：
    //
    //输入：height = [4,2,0,3,2,5]
    //输出：9
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int n = height.length;
        int leftIndex = 1;
        int rightIndex = n - 2;
        int leftBorder = height[0];
        int rightBorder = height[n - 1];
        int res = 0;
        while (leftIndex <= rightIndex) {
            if (leftBorder <= rightBorder) {
                // 左侧为短板
                if (height[leftIndex] > leftBorder) {
                    // 不产生res。更换短板
                    leftBorder = height[leftIndex];
                } else {
                    res += leftBorder - height[leftIndex];
                }
                leftIndex++;
            } else {
                if (height[rightIndex] > rightBorder) {
                    rightBorder = height[rightIndex];
                } else {
                    res += rightBorder - height[rightIndex];
                }
                rightIndex--;
            }

        }
        return res;

    }

    public int trap1(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
