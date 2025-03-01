package class04_string;

import java.util.Scanner;

public class Code03_ReplaceNum {
    //给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，
    // 将字符串中的字母字符保持不变，而将每个数字字符替换为number。
    // 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
    public static String replaceNum(String s) {
        char[] arr = s.toCharArray();
        int numCount = 0; // 数字字符个数
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                numCount++;
            }
        }
        char[] res = new char[s.length() + numCount * 5];
        int index = 0;
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                res[index++] = 'n';
                res[index++] = 'u';
                res[index++] = 'm';
                res[index++] = 'b';
                res[index++] = 'e';
                res[index++] = 'r';

            } else {
                res[index++] = c;
            }

        }
        return String.valueOf(res);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = replaceNum(s);
        System.out.println(res);

    }
}
