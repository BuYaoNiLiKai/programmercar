package class02_linkedlist;

public class Code03_Reverse {
    public ListNode reverseList(ListNode head) {
        // 最多一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 至少两个节点
        ListNode pre = null;
        ListNode cur = head; // 每次反转cur的next
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
