package class01_array;

import java.util.Scanner;

/*
给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和
第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，
表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
 */
public class Code06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] preSum = new int[n];
        int sum = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int tmp;
            tmp = scanner.nextInt();
            sum += tmp;
            preSum[index++] = sum;
        }
        int l;
        int r;
        while (scanner.hasNextInt()) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            if (l == 0) {
                System.out.println(preSum[r]);
            } else {
                System.out.println(preSum[r] - preSum[l - 1]);
            }

        }
    }
}
