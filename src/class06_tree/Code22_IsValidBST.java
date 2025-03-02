package class06_tree;

public class Code22_IsValidBST {
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //有效 二叉搜索树定义如下：
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。

    // 中序遍历为升序数组
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long leftMax, long rightMin) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftMax || root.val >= rightMin) {
            return false;
        }
        return isValidBST(root.left, leftMax, root.val) && isValidBST(root.right, root.val, rightMin);
    }

    class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return process(root).isBST;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        boolean is = left.isBST && right.isBST && root.val > left.max && root.val < right.min;
        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));
        return new Info(is, max, min);

    }

}
