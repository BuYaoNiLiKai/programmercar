package class06_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code16_FindBottomLeftValue {
    //给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
    //假设二叉树中至少有一个节点。
    // 做法1     层次遍历的最后一层的第一个出现的节点！
    // 做法2 利用中序遍历
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    public int findBottomLeftValue(TreeNode root) {
        int height = getMaxDepth(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            height--;
            if (height == 0) {
                return queue.poll().val;
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
