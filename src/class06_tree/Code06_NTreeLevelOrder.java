package class06_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code06_NTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> curLevel = new ArrayList<>();
        Node curLevelEnd = root; //当前层的最后一个节点
        Node nextLevelEnd = root;
        Node cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curLevel.add(cur.val);
            for (Node node : cur.children) {
                queue.add(node);
                nextLevelEnd = node;
            }
            if (cur == curLevelEnd) {
                res.add(new ArrayList<>(curLevel));
                curLevel.clear();
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderPlus(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> curLevel = new ArrayList<>();
        Node cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                cur = queue.poll();
                curLevel.add(cur.val);
                for (Node node : cur.children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
            }
            res.add(new ArrayList<>(curLevel));
            curLevel = new ArrayList<>();
       
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
