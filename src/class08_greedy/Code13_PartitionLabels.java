package class08_greedy;

import java.util.ArrayList;
import java.util.List;

public class Code13_PartitionLabels {
    //给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
    // 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"]
    // 或 ["ab", "ab", "cc"] 的划分是非法的。
    //注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
    //返回一个表示每个字符串片段的长度的列表。
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] right = new int[26]; // 26个字母的右边界 最后一次出现
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            right[arr[i] - 'a'] = i;
        }
        int nowEnd = -1;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur++;
            nowEnd = Math.max(right[arr[i] - 'a'], nowEnd);
            if (i == nowEnd) {
                res.add(cur);
                cur = 0;
                nowEnd = -1;
            }

        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
