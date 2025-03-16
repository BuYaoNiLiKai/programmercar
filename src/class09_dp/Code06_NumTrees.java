package class09_dp;

public class Code06_NumTrees {
    public static int numTrees(int n) {
        return numTrees(1, n);
    }

    public static int numTrees(int left, int right) {
        if (left >= right) {
            return 1;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int leftNums = numTrees(left, i - 1);
            int rightNums = numTrees(i + 1, right);
            int tmp = rightNums * leftNums;
            res += tmp;
        }
        return res;
    }

    public static int numTreesDp(int n) {
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1]; //dp[i] 记录n个节点可以构成的二叉搜索树
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 当前整棵树一共i个节点（1~i）
            int tmp = 0;
            for (int j = 0; j <= i - 1; j++) {
                //根节点为 i-j
                //那么j为左子树的节点个数
                //i-j-1 就是右子树的节点个数
                int numLeft = dp[j];
                int numRight = dp[i - j - 1];
                int total = numLeft * numRight;
                tmp += total;
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTreesDp(3));
    }
}
