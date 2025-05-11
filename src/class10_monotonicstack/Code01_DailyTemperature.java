package class10_monotonicstack;

import java.util.LinkedList;
import java.util.Stack;

public class Code01_DailyTemperature {
    //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i]
    // 是指对于第 i 天，
    // 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    //示例 1:
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]
    //示例 2:
    //输入: temperatures = [30,40,50,60]
    //输出: [1,1,1,0]
    //示例 3:

    //输入: temperatures = [30,60,90]
    //输出: [1,1,0]
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();// 存放下标
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.add(i);
        }
//        while (!stack.isEmpty()) {
//            int index = stack.pop();
//            res[index] = 0;
//        }
        return res;

    }

    public static void main(String[] args) {
        int[] temperatures = {30, 60, 90};
        int[] res = dailyTemperatures(temperatures);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
