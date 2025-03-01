package class06_tree;

import java.util.*;

public class Code04_LevelOrder {


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> curLevel = new ArrayList<>();
        TreeNode curLevelEnd = root; //当前层的最后一个节点
        TreeNode nextLevelEnd = root;
        TreeNode cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curLevel.add(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if (cur == curLevelEnd) {
                res.add(new ArrayList<>(curLevel));
                curLevel = new ArrayList<>();
                curLevelEnd = nextLevelEnd;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Stack<List<Integer>> res = new Stack<>();
        List<List<Integer>> real = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> curLevel = new ArrayList<>();
        TreeNode curLevelEnd = root; //当前层的最后一个节点
        TreeNode nextLevelEnd = root;
        TreeNode cur;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curLevel.add(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if (cur == curLevelEnd) {
                res.add(new ArrayList<>(curLevel));
                curLevel.clear();
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
            }
        }
        while (!res.isEmpty()) {
            real.add(res.pop());
        }
        return real;
    }

    public static List<List<Integer>> levelOrderPlus(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);

                // 将当前节点的子节点加入队列
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            res.add(curLevel); // 添加当前层的结果
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(tree);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
