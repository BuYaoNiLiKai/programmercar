package class08_greedy;

public class Code02_WiggleMaxLength {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        boolean sign = false;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i] - nums[i - 1];
            if (val != 0) {
                if (flag) {
                    sign = !(val > 0);
                    flag = false;
                    res++;
                } else {
                    if (check(val, sign)) {
                        res++;
                        sign = !sign;
                    }
                }
            }

        }
        return res + 1;
    }

    public static boolean check(int n, boolean flag) {

        return (n > 0 && flag) || (n < 0 && !flag);
    }

    public static void main(String[] args) {
        int[] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(arr));
    }
}
