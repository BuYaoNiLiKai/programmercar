package class00_datastructure;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);
        list.headInsert(1);
        list.headInsert(2);
        list.tailInsert(3);
        list.tailInsert(5);
        list.headInsert(4);
        list.printList();
        list.deleteEle(6);
        list.deleteEle(2);
        list.printList();
        list.deleteEle(5);
        list.printList();

    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public LinkedList(int val) {
        Node tmp = new Node(val);
        head = tail = tmp;
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public void headInsert(int val) {
        if (size == 0) {
            head = tail = new Node(val);
            size++;
        } else {
            Node tmp = new Node(val);
            tmp.next = head;
            head = tmp;
            size++;

        }
        System.out.println("head insert success");
    }

    public void tailInsert(int val) {
        if (size == 0) {
            head = tail = new Node(val);
        } else {
            Node tmp = new Node(val);
            tail.next = tmp;
            tail = tmp;
            size++;
        }
        System.out.println("tail insert success");
    }

    public void printList() {
        if (size == 0) {
            System.out.println("null");
        } else {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.val + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    public void deleteEle(int val) {
        if (size == 0) {
            System.out.println("list is null");
        }
        if (head.val == val) {
            head = head.next;
            size--;
            return;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                size--;
                System.out.println("delete success");
                return;
            }
            cur = cur.next;
            pre = pre.next;
        }
        System.out.println("not found");
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }
}