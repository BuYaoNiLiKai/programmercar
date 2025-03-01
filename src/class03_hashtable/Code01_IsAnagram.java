package class03_hashtable;

public class Code01_IsAnagram {
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {

    }
}
