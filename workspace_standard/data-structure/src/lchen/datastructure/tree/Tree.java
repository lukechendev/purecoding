package lchen.datastructure.tree;

public class Tree {

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        root.insert(data);
    }

    public boolean contains(int data) {
        if (root == null) {
            return false;
        }

        return root.contains(data);
    }

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
            System.out.println();
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
            System.out.println();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.insert(17);
        tree.insert(4);
        tree.insert(15);
        tree.insert(19);
        tree.insert(7);

        tree.printInOrder(); // 1,2,3,4,5,6,7,15,17,19
        tree.printPreOrder(); // 5,2,1,3,4,6,17,15,7,19
        tree.printPostOrder(); // 1,4,3,2,7,15,19,17,6,5

        System.out.println("contains 15: " + tree.contains(15));
        System.out.println("contains 5: " + tree.contains(5));
        System.out.println("contains 1: " + tree.contains(1));
        System.out.println("contains 8: " + tree.contains(8));
        System.out.println("contains 20: " + tree.contains(20));
        System.out.println("contains 0: " + tree.contains(0));
        System.out.println("contains 16: " + tree.contains(16));

        tree.insert(16);

        System.out.println("contains 16: " + tree.contains(16));

        tree.printInOrder(); // 1,2,3,4,5,6,7,15,16,17,19
        tree.printPreOrder(); // 5,2,1,3,4,6,17,15,7,16,19
        tree.printPostOrder(); // 1,4,3,2,7,16,15,19,17,6,5
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }

        private void insert(int data) {
            if (data <= this.data) {
                if (left == null) {
                    left = new Node(data);
                } else {
                    left.insert(data);
                }
            } else {
                if (right == null) {
                    right = new Node(data);
                } else {
                    right.insert(data);
                }
            }
        }

        private boolean contains(int data) {
            if (this.data == data) {
                return true;
            }

            if (data <= this.data) {
                if (left != null) {
                    return left.contains(data);
                }
            } else {
                if (right != null) {
                    return right.contains(data);
                }
            }

            return false;
        }

        private void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }

            System.out.print(data + ",");

            if (right != null) {
                right.printInOrder();
            }
        }

        private void printPreOrder() {
            System.out.print(data + ",");

            if (left != null) {
                left.printPreOrder();
            }

            if (right != null) {
                right.printPreOrder();
            }
        }

        private void printPostOrder() {
            if (left != null) {
                left.printPostOrder();
            }

            if (right != null) {
                right.printPostOrder();
            }

            System.out.print(data + ",");
        }
    }
}
