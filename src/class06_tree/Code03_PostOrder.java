package class06_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code03_PostOrder {
    //  后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            vals.add(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.left);
            }
        }
        while (!vals.isEmpty()) {
            res.add(vals.pop());
        }
        return res;
    }
}
