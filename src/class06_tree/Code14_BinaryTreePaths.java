package class06_tree;

import java.util.ArrayList;
import java.util.List;

public class Code14_BinaryTreePaths {
    //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
    //叶子节点 是指没有子节点的节点。
    //输入：root = [1,2,3,null,5]
    //输出：["1->2->5","1->3"]
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        finPath(root, "", res);
        return res;
    }

    public void finPath(TreeNode root, String curPath, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(curPath + root.val);
            return;
        }
        if (root.left != null) {
            finPath(root.left, curPath + root.val + "->", res);
        }
        if (root.right != null) {
            finPath(root.right, curPath + root.val + "->", res);
        }

    }

    public static void main(String[] args) {

    }
}
