package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code04_LetterCombinations {
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    List<String> res = new ArrayList<>();
    int[] arr = {0, 0, 0, 3, 6, 9, 12, 15, 19, 22, 26};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        letterCombinations(0, digits, sb);
        return res;

    }

    public void letterCombinations(int index, String digits, StringBuilder cur) {
        //来到了index位置
        if (index == digits.length()) {
            res.add(new String(cur));
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (int i = arr[digit]; i < arr[digit + 1]; i++) {
            char c = (char) ('a' + i);
            cur.append(c);
            letterCombinations(index + 1, digits, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        Code04_LetterCombinations l = new Code04_LetterCombinations();
        List<String> res = l.letterCombinations("23");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
