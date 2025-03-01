package class06_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code02_InOrder {
    // 左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
