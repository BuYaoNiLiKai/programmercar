package class06_tree;

public class Code13_IsBalanced {
    //给定一个二叉树，判断它是否是 平衡二叉树    左右高度相差<2
    class Info {
        boolean isBst;
        int height;

        public Info(boolean isBst, int height) {
            this.isBst = isBst;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root).isBst;
    }

    public Info isBST(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);// 空节点
        }
        Info leftInfo = isBST(root.left);
        Info rightInfo = isBST(root.right);
        // 左树是平衡的 右树也是。相差高度<2
        boolean is = leftInfo.isBst && rightInfo.isBst && Math.abs(leftInfo.height - rightInfo.height) < 2;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(is, height);
    }

    public boolean isBSTPlus(TreeNode root) {
        return height(root) >= 0;

    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {

    }
}
