package class08_greedy;

public class Code07_CanComplete {
    //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    //你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
    // 你从其中的一个加油站出发，开始时油箱为空。
    //给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，
    // 否则返回 -1 。如果存在解，则 保证 它是 唯一 的
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            //出发点
            int nowGas = 0;
            for (int j = 0; j < n; j++) {
                nowGas = nowGas + gas[(i + j) % n] - cost[(i + j) % n];
                if (nowGas < 0) {
                    break;
                }
            }
            if (nowGas >= 0) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
