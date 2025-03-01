package class06_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code06_Average {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        double sum = 0;
        double count = 0;
        TreeNode curLevelEnd = root; //当前层的最后一个节点
        TreeNode nextLevelEnd = root;
        TreeNode cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            sum += cur.val;
            count++;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if (cur == curLevelEnd) {
                res.add(sum / count);
                sum = count = 0;
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
            }
        }
        return res;
    }
}
