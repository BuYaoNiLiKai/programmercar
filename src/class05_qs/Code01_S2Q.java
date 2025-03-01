package class05_qs;

import java.util.Scanner;
import java.util.Stack;

public class Code01_S2Q {
    // 栈实现队列
}

class MyQueue {
    // a b两个栈互相倒
    Stack<Integer> a;
    Stack<Integer> b;

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.add(x);
    }

    public int pop() {
        //如果b非空 返回b的第一个元素
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.add(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.add(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
