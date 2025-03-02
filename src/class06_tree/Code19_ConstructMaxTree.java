package class06_tree;

public class Code19_ConstructMaxTree {
    //给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
    //创建一个根节点，其值为 nums 中的最大值。
    //递归地在最大值 左边 的 子数组前缀上 构建左子树。
    //递归地在最大值 右边 的 子数组后缀上 构建右子树。
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            maxIndex = nums[maxIndex] > nums[i] ? maxIndex : i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        TreeNode left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        TreeNode right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

    }
}
