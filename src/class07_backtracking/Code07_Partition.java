package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code07_Partition {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partitionHelper(s, 0, new StringBuilder());
        return res;
    }

    public void partitionHelper(String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValid(sb)) {
                path.add(sb.toString());
                partitionHelper(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }

        }
    }

    public boolean isValid(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        String s = new String(arr);

        System.out.println(new String(arr, 3, 2));
    }
}
