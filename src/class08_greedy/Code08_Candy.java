package class08_greedy;

public class Code08_Candy {
    //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    //你需要按照以下要求，给这些孩子分发糖果：
    //每个孩子至少分配到 1 个糖果。
    //相邻两个孩子评分更高的孩子会获得更多的糖果。
    //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    public static int candy(int[] ratings) {

        int[] arr = new int[ratings.length];
        arr[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
            }
        }
        int res = arr[arr.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
            res += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 87, 87, 87, 2, 1};
        System.out.println(candy(arr));
    }
}
