package class07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class hello {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }

        combineHelper(n, k);
        return res;
    }

    public void combineHelper(int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (n < k) {
            return;
        }
        // 要和不要
        path.add(n);
        combineHelper(n - 1, k - 1);
        path.remove(path.size() - 1);
        combineHelper(n - 1, k);
    }
}
