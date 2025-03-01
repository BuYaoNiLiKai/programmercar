package class04_string;

import java.util.Scanner;

public class Code04_RightRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String s;
        n = sc.nextInt();
        s = sc.next();
        int length = s.length();
        n = n % length;
        if (n == 0) {
            return;

        }
        char[] arr = s.toCharArray();
        char[] res = new char[arr.length];
        for (int i = 0; i < length; i++) {
            res[(i + n) % length] = arr[i];
        }
        System.out.println(String.valueOf(res));

    }
}
