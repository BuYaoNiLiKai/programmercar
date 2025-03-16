package class08_greedy;

import class06_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Code16_MinCamearCover {
    //给定一个二叉树，我们在树的节点上安装摄像头。
    //节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
    //计算监控树的所有节点所需的最小摄像头数量。
    public int minCameraCover(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    res++;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
