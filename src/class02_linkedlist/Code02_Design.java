package class02_linkedlist;

public class Code02_Design {
}

class MyLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    int length;// 当前的链表长度
    ListNode head; //头
    ListNode tail; //尾节点

    public MyLinkedList() {
        length = 0;
        head = tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (length == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (length == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        // void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为
        // index 的节点之前。如果 index 等于链表的长度，
        // 那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            ListNode cur = head;
            while (index - 1 > 0) {
                cur = cur.next;
                index--;
            }
            ListNode node = new ListNode(val);
            node.next = cur.next;
            cur.next = node;
            length++;
        }
    }

    //void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            if (index == 0) {
                head = head.next;
            } else {
                ListNode cur = head;
                int tmp = index;
                while (index - 1 > 0) {
                    cur = cur.next;
                    index--;
                }
                cur.next = cur.next.next;
                if (tmp == length - 1) {
                    tail = cur;
                }
            }
            length--;
        }

    }
}