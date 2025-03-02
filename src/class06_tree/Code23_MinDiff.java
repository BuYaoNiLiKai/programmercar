package class06_tree;

public class Code23_MinDiff {
    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    //差值是一个正数，其数值等于两值之差的绝对值。
    int pre; //上个节点的值
    int res;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
