package lchen.datastructure.queue;

import java.util.NoSuchElementException;

public class Queue {
    Node head; // always remove from head
    Node tail; // always add to tail

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

    // To test
    public static void main(String[] args) {
        System.out.println("Queue");
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
