package class06_tree;

import java.awt.*;

public class Code09_GetMaxMinDepth {
    //二叉树的最大最小深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果左子树为空，递归右子树
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 如果右子树为空，递归左子树
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 如果左右子树都不为空，返回左右子树的最小深度
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

    public static void main(String[] args) {

    }
}
