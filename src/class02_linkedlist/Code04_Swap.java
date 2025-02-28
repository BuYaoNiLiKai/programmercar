package class02_linkedlist;

public class Code04_Swap {
    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    // 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    public ListNode swapPairs(ListNode head) {
        // 最多一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 至少有一对儿  第一对特殊处理 因为之后的需要记录上一对儿的最后一个节点
        ListNode res = head.next;
        ListNode first = head;
        ListNode pre = head;
        ListNode second;
        ListNode next;
        while (first != null && first.next != null) {
            // 处理first开头的一对儿
            second = first.next;
            next = second.next;// 下一对儿的开始
            first.next = next;
            second.next = first;
            if (first != head) {
                pre.next = second;
                pre = first;
            }
            first = next;
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
