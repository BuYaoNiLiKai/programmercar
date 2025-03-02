package class06_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Code24_findMode {
    //给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
    //如果树中有不止一个众数，可以按 任意顺序 返回。
    //假定 BST 满足如下定义：
    //结点左子树中所含节点的值 小于等于 当前节点的值
    //结点右子树中所含节点的值 大于等于 当前节点的值
    //左子树和右子树都是二叉搜索树
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.right;
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int maxCount = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > maxCount) {
                maxCount = map.get(i);
                res.clear();
                res.add(i);
            } else if (map.get(i) == maxCount) {
                res.add(i);
            }


        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
