package class03_hashtable;

import java.util.HashMap;

public class COde05_FourAdd {
    //给你四个整数数组 nums1、nums2、nums3 和 nums4 ，
    // 数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足
    //0 <= i, j, k, l < n
    //nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;// key出现的次数
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
