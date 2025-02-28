package class02_linkedlist;

public class Code01_Remove {
    /*
    给你一个链表的头节点 head 和一个整数 val ，
    请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    public ListNode removeElements(ListNode head, int val) {
        // 处理头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
