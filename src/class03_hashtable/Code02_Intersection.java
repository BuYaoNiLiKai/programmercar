package class03_hashtable;

import java.util.*;

public class Code02_Intersection {
    //给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。
    // 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {
            return nums2;
        }
        if (nums2 == null || nums2.length < 1) {
            return nums1;
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] arr = new int[res.size()];
        int index = 0;
        for (int i : res) {
            arr[index++] = i;
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
