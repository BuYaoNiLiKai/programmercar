package class03_hashtable;

public class Code06_CanConstruct {
    //给你两个字符串：ransomNote 和 magazine ，
    // 判断 ransomNote 能不能由 magazine 里面的字符构成。
    //如果可以，返回 true ；否则返回 false 。
    //magazine 中的每个字符只能在 ransomNote 中使用一次。
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
