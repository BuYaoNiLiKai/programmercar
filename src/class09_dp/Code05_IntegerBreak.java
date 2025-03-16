package class09_dp;

public class Code05_IntegerBreak {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= Math.sqrt(i) + 1; j++) {
                // j* i-j
                //dp[j]*dp[i-j]
                // dp[j]*i-j
                // i *dp[i-j]
                int a = Math.max(j, dp[j]);
                int b = Math.max(i - j, dp[i - j]);
                max = Math.max(max, a * b);

            }
            dp[i] = max;
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(dp[i] + "   ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(15));
    }
}
