package class06_tree;

import java.util.HashMap;
import java.util.Map;

public class Code18_BuildTree {
    //给定两个整数数组 inorder 和 postorder ，其
    // 中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
    // 请你构造并返回这颗 二叉树 。
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        // 预处理inorder的索引位置
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    // 利用inorder的 is~ie 和ostorder的ps~pe构建一二叉树
    // in: 左中右
    // post：左右中
    public static TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> inMap) {

        if (is > ie || ps > pe) {
            return null;
        }
        // 根节点的值是postorder[pe]
        TreeNode root = new TreeNode(postorder[pe]);
        // 在inorder中找到 根节点的值
        int divide = inMap.get(postorder[pe]);
        //divide为先序遍历的跟节点。因为是左中右 所以 is~divide-1为左树 divide+1~ie为右树
        TreeNode left = buildTree(inorder, is, divide - 1, postorder, ps, ps + divide - is - 1, inMap);
        TreeNode right = buildTree(inorder, divide + 1, ie, postorder, pe + divide - ie, pe - 1, inMap);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);

    }
}
