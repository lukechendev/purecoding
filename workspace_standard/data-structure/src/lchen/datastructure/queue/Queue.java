package lchen.datastructure.queue;

import java.util.NoSuchElementException;

public class Queue {
    private Node head; // always remove from head
    private Node tail; // always add to tail

    public void add(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    public int poll() {
        if (head != null) {
            int data = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            return data;
        }

        throw new NoSuchElementException();
    }

    public int peek() {
        if (head != null) {
            return head.data;
        }

        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        Node current = head;
        while (current != null) {
            sb.append(current.data).append(",");
            current = current.next;
        }

        if (head != null) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    // To test
    public static void main(String[] args) {
        System.out.println("Queue");

        Queue queue = new Queue();
        queue.print();

        try {
            queue.peek();
        } catch (NoSuchElementException ex) {
            System.out.println("peek empty: " + ex);
        }

        try {
            queue.poll();
        } catch (NoSuchElementException ex) {
            System.out.println("poll empty:" + ex);
        }

        queue.add(1); // 1
        queue.print();
        queue.add(2); // 1,2
        queue.print();
        queue.add(3); // 1,2,3
        queue.print();
        queue.add(4); // 1,2,3,4
        queue.print();
        System.out.println(queue.poll()); // 1 // 2,3,4
        queue.print();
        System.out.println(queue.peek()); // 2 // 2,3,4
        queue.print();
        System.out.println(queue.isEmpty()); // false // 2,3,4
        queue.print();
        System.out.println(queue.poll()); // 2 // 3,4
        queue.print();
        System.out.println(queue.poll()); // 3 // 4
        queue.print();
        queue.add(5); // 4,5
        queue.print();
        System.out.println(queue.poll()); // 4 // 5
        queue.print();
        System.out.println(queue.poll()); // 5 //
        queue.print();
        System.out.println(queue.isEmpty()); // true //
        queue.print();
    }

    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}
