package class05_qs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//输入: nums = [1], k = 1
//输出: [1]
public class Code07_TopKFrequent {
    public static class Node {
        int val;
        int times;

        public Node(int v, int t) {
            val = v;
            times = t;
        }
    }

    public static class Compare implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o2.times;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Node> fMap = new HashMap<>(); //频率表
        for (int i : nums) {
            if (fMap.containsKey(i)) {
                fMap.get(i).times++;
            } else {
                fMap.put(i, new Node(i, 1));
            }
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(new Compare());
        for (Node node : fMap.values()) {
            if (heap.isEmpty() || heap.size() < k) {
                heap.add(node);
            } else {
                if (node.times > heap.peek().times) {
                    heap.poll();
                    heap.add(node);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll().val;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 6, 6, 6, 6, 8, 9, 1, 11, 1, 1};
        int[] res = topKFrequent((arr), 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
