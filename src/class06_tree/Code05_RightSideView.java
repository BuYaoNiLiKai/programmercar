package class06_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code05_RightSideView {
    //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    //示例 1：
    //输入：root = [1,2,3,null,5,null,4]
    //输出：[1,3,4]
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curLevelEnd = root; //当前层的最后一个节点
        TreeNode nextLevelEnd = root;
        TreeNode cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if (cur == curLevelEnd) {
                res.add(cur.val);
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
