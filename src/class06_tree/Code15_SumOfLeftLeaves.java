package class06_tree;

public class Code15_SumOfLeftLeaves {
    //给定二叉树的根节点 root ，返回所有左叶子之和。
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left, true) +
                sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        // root是不是左孩子
        if (root == null) {
            return 0;
        }
        // 来到了叶子结点 是左孩子 返回值 否则返回0
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        // 有孩子
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public static void main(String[] args) {

    }
}
