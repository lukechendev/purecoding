package lchen.datastructure.linkedlist;

public class LinkedList {

    private Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        Node current = head;
        while (current != null) {
            sb.append(current.data).append(",");
            current = current.next;
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    // To test
    public static void main(String[] args) {
        System.out.println("LinkedList");

        LinkedList list = new LinkedList();
        list.append(1); // 1
        list.print();
        list.append(2); // 1,2
        list.print();
        list.append(3); // 1,2,3
        list.print();
        list.append(4); // 1,2,3,4
        list.print();
        list.prepend(1); // 1,1,2,3,4
        list.print();
        list.prepend(5); // 5,1,1,2,3,4
        list.print();
        list.deleteWithValue(1); // 5,1,2,3,4
        list.print();
        list.deleteWithValue(5); // 1,2,3,4
        list.print();
        list.deleteWithValue(4); // 1,2,3
        list.print();
        list.deleteWithValue(4); // 1,2,3
        list.print();

        LinkedList list2 = new LinkedList();
        list2.deleteWithValue(1);
        list2.print();
    }

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}
