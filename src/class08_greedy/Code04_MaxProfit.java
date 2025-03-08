package class08_greedy;

public class Code04_MaxProfit {
    //给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
    //在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);

        }
        return res;
    }
}
