package class05_qs;

import java.util.Stack;

public class Code03_IsValid {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //每个右括号都有一个对应的相同类型的左括号。
    //"([)]" ->false
    boolean fit(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.add(arr[i]);
            } else {
                if (stack.isEmpty() || !(fit(stack.pop(), arr[i]))) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
