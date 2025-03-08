package class08_greedy;

import java.util.Arrays;

public class Code01_Cookies {
    //假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
    //对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
    // 都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到
    // 满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < s.length && i < g.length) {
            if (s[j] >= g[i]) {
                res++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int res = findContentChildren(g, s);
        System.out.println(res);
    }
}
