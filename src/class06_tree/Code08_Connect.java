package class06_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Code08_Connect {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node cur;
            Node pre = queue.peek();
            for (int i = 0; i < levelSize; i++) {
                cur = queue.poll();
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (i != 0) {
                    cur.next = pre;
                }
                pre = cur;

            }
        }
        return root;
    }
}
