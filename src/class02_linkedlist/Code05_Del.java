package class02_linkedlist;

public class Code05_Del {
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        int length = 0; // 链表的长度
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        //先判断是否违规
        if (n > length) {
            return head;
        }
        // 倒数第n个 就是正数 length -n+1个
        if (n == length) { //删除头
            head = head.next;
        } else {
            // 来到前一个节点
            cur = head;
            n = length - n + 1;
            while (n > 2) {
                cur = cur.next;
                n--;
            }
            cur.next = cur.next.next;
        }
        return head;

    }

    public static void main(String[] args) {

    }
}
