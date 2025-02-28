package class02_linkedlist;

public class Code06_Insertion {
    //给你两个单链表的头节点 headA 和 headB ，
    // 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int gap = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null) {
            gap++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            gap--;
            cur2 = cur2.next;
        }
        // 使cur1 指向长的 cur2指向短的
        cur1 = gap > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        // cur1先走 abs(gap)步 对齐
        gap = Math.abs(gap);
        while (gap > 0) {
            cur1 = cur1.next;
            gap--;
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
