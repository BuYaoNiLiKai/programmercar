package class04_string;

public class Code01_ReverseString {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    public void reverseString(char[] s, int start, int end) {
        while (start <= end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符
    // ，就反转这 2k 字符中的前 k 个字符。
    //如果剩余字符少于 k 个，则将剩余字符全部反转。
    //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int rounds = s.length() / (2 * k); //一共几轮
        int residual = s.length() % (2 * k);
        for (int i = 0; i < rounds; i++) {
            reverseString(arr, 2 * i * k, 2 * k * i + k - 1);
        }
        residual = Math.min(residual, k);
        reverseString(arr, 2 * rounds * k, 2 * k * rounds + residual - 1);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {

    }
}
