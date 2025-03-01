package class05_qs;

import java.util.LinkedList;
import java.util.Queue;

public class Code02_Q2S {
    //队列实现栈
}

class MyStack {
    Queue<Integer> a;
    Queue<Integer> b;
    boolean index; //默认为a

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
        index = true;
    }

    public void push(int x) {
        if (index) {
            a.add(x);
        } else {
            b.add(x);
        }
    }

    public int pop() {
        if (index) {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            index = !index;
            return a.poll();
        } else {
            while (b.size() > 1) {
                a.add(b.poll());
            }
            index = !index;
            return b.poll();
        }

    }

    public int top() {
        if (index) {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            return a.peek();
        } else {
            while (b.size() > 1) {
                a.add(b.poll());
            }
            return b.peek();
        }
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}