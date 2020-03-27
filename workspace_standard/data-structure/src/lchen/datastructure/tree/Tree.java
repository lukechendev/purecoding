package lchen.datastructure.tree;

public class Tree {

    Node root;

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
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
        }
    }

    public static void main(String[] args) {
        
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

            System.out.println(data);

            if (right != null) {
                right.printInOrder();
            }
        }

        private void printPreOrder() {
            System.out.println(data);

            if (left != null) {
                left.printInOrder();
            }

            if (right != null) {
                right.printInOrder();
            }
        }

        private void printPostOrder() {
            if (left != null) {
                left.printInOrder();
            }

            if (right != null) {
                right.printInOrder();
            }

            System.out.println(data);
        }
    }
}
