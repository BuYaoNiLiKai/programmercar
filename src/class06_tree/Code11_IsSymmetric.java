package class06_tree;

public class Code11_IsSymmetric {
    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);

    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return isSame(left.left, right.right) &&
                    isSame(left.right, right.left) &&
                    left.val == right.val;
        }
        //有一个不为空
        return false;

    }
}
