package class06_tree;

public class Code26_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root.val > val ? root.left : root.right;
        boolean left = root.val > val;
        TreeNode pre = root;
        while (cur != null) {
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
                left = true;
            } else {
                cur = cur.right;
                left = false;
            }
        }
        if (left) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
