package class05_qs;

import java.util.Stack;

public class Code05_EvalRPN {
    //给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
    //请你计算该表达式。返回一个表示表达式值的整数。
    //注意：
    //有效的算符为 '+'、'-'、'*' 和 '/' 。
    //每个操作数（运算对象）都可以是一个整数或者另一个表达式。
    //两个整数之间的除法总是 向零截断 。
    //表达式中不含除零运算。
    //输入是一个根据逆波兰表示法表示的算术表达式。
    //答案及所有中间计算结果可以用 32 位 整数表示
    //输入：tokens = ["2","1","+","3","*"]
    //输出：9
    //解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
    public static int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        for (String s : tokens) {
            if (s.length() > 1) {
                int v = Integer.parseInt(s);
                val.add(v);
            } else {
                char c = s.charAt(0);
                if (c >= '0' && c <= '9') {
                    val.add(c - '0');
                } else {
                    int a = val.pop();
                    int b = val.pop();
                    switch (c) {
                        case '+':
                            val.add(a + b);
                            break;
                        case '-':
                            val.add(b - a);
                            break;
                        case '*':
                            val.add(b * a);
                            break;
                        case '/':
                            val.add(b / a);
                            break;
                        default:
                            break;
                    }

                }
            }

        }
        return val.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }
}
