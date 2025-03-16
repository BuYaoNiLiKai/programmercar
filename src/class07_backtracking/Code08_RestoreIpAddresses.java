package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code08_RestoreIpAddresses {
    public static List<String> res = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Code08_RestoreIpAddresses code05RestoreIpAddresses = new Code08_RestoreIpAddresses();
        code05RestoreIpAddresses.restoreIpAddresses("0000");
        for (String s : res) {
            System.out.println(s);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresseshelper(s, 0, 4);
        return res;
    }

    // index 来到的位置 numPoint剩余的小数点个数
    public void restoreIpAddresseshelper(String s, int index, int numGroup) {
        // 加速 不够用或者是太多了
        int residual = s.length() - index;
        if (residual > numGroup * 3 || residual < numGroup) {
            return;
        }
        //终止条件
        if (index == s.length() || numGroup == 0) {
            if (index == s.length() && numGroup == 0) {
                res.add(new String(sb));
            }
            return;
        }
        // ip地址转换
        int len = 0;
        // 开头为0 或者越界
        if (s.charAt(index) == '0' || index + 1 >= s.length()) {
            len = 1;
        } else {
            // 开头不为0 并且至少俩数
            len = 2;
            int val = 0;
            if (index + 2 < s.length()) {
                val = Integer.parseInt(s.substring(index, index + 3));
                if (val <= 255) {
                    len = 3;
                }
            }

        }
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(index + i));
        }
        while (len > 0) {
            if (numGroup > 1) {
                sb.append('.');
            }
            restoreIpAddresseshelper(s, index + len, numGroup - 1);
            if (numGroup > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.deleteCharAt(sb.length() - 1);
            len--;
        }


    }


}
