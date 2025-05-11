package class06_tree;

public class Code10_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root, root.left, root.right);
        return root;
    }

    public void invertTree(TreeNode root, TreeNode left, TreeNode right) {
        // 交换左左 右右   左右 右左
        if (left != null) {
            invertTree(left, left.left, left.right);
        }
        if (right != null) {
            invertTree(right, right.left, right.right);
        }
        //交换当前
        root.left = right;
        root.right = left;
    }

    public static void main(String[] args) {

    }
}
