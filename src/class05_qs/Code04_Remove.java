package class05_qs;

import java.util.Stack;

public class Code04_Remove {
    //给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
    //在 s 上反复执行重复项删除操作，直到无法继续删除。
    //在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    //输入："abbaca"
    //输出："ca"
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != arr[i]) {
                stack.add(arr[i]);
            } else {
                stack.pop();
            }
        }
        char[] res = new char[stack.size()];
        int index = res.length - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcdccdc"));
    }
}
