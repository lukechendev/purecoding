package lchen.datastructure.stack;

import java.util.NoSuchElementException;

public class Stack {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top != null) {
            return top.data;
        }

        throw new NoSuchElementException();
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (top != null) {
            int data = top.data;
            top = top.next;
            return data;
        }

        throw new NoSuchElementException();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        Node current = top;
        while (current != null) {
            sb.append(current.data).append(",");
            current = current.next;
        }

        if (top != null) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    // To test
    public static void main(String[] args) {
        System.out.println("stack");

        Stack stack = new Stack();
        stack.print();

        try {
            stack.peek();
        } catch (NoSuchElementException ex) {
            System.out.println("peek empty: " + ex);
        }

        try {
            stack.pop();
        } catch (NoSuchElementException ex) {
            System.out.println("pop empty:" + ex);
        }

        stack.push(1); // 1
        stack.print();
        stack.push(2); // 2,1
        stack.print();
        stack.push(3); // 3,2,1
        stack.print();
        stack.push(4); // 4,3,2,1
        stack.print();
        System.out.println(stack.pop()); // 4 // 3,2,1
        stack.print();
        System.out.println(stack.peek()); // 3 // 3,2,1
        stack.print();
        System.out.println(stack.isEmpty()); // false // 3,2,1
        stack.print();
        System.out.println(stack.pop()); // 3 // 2,1
        stack.print();
        System.out.println(stack.pop()); // 2 // 1
        stack.print();
        stack.push(5); // 5,1
        stack.print();
        System.out.println(stack.pop()); // 5 // 1
        stack.print();
        System.out.println(stack.pop()); // 1 //
        stack.print();
        System.out.println(stack.isEmpty()); // true //
        stack.print();
    }

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}