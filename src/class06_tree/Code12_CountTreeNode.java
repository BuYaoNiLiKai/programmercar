package class06_tree;

public class Code12_CountTreeNode {
    //给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    //完全二叉树 的定义如下：在完全二叉树中，
    // 除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    // 并且最下面一层的节点都集中在该层最左边的若干位置。
    // 若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {

    }

}
