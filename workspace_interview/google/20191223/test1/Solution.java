/*
  Google 
  Kevin, security related
  phone + Google doc
  Lasted ~50m (a bit overtime (45min))

  Given a binary tree, return a node with the greatest depth
  1) With recursion;
  2) Without recursion;
*/

import java.util.LinkedList;

public class Solution {
  // with recursion
  private Node doTraversal(Node node) {
    Node leftGreatest = null;
    Node rightGreatest = null;

    if (node.left != null) {
      leftGreatest = doTraversal(node.left);
    }

    if (node.right != null) {
      rightGreatest = doTraversal(node.right);
    }

    if (leftGreatest != null && rightGreatest != null) {
      if (leftGreatest.depth > rightGreatest.depth) {
        return leftGreatest;
      } else {
        return rightGreatest;
      }
    } else if (leftGreatest != null) {
        return leftGreatest;
    } else if (rightGreatest != null) {
        return rightGreatest;
    } else {
        return node;
    }
  }

  public Node findGreatestDepth1(Node root) {
    if (root == null) {
      return null;
    }

    return doTraversal(root);
  }
  
  public Node findGreatestDepth2(Node root) {
    Node node = null;

    if (root == null) {
      return null;
    }

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (queue.size() != 0) {
      node = queue.poll();
      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }

    }

    return node;
  }

  public static void test(Node root, Node expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    Node ret = s.findGreatestDepth1(root);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret + "\n Expected: " + expected);
    }
  }

  public static void test2(Node root, Node expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    Node ret = s.findGreatestDepth2(root);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret + "\n Expected: " + expected);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1, 0);
    root.left = new Node(2, 1);
    root.right = new Node(3, 1);
    root.left.left = new Node(4, 2);
    root.left.right = new Node(5, 2);
    root.right.left = new Node(6, 2);
    root.right.left.right = new Node(7, 3);
    Node expected = root.right.left.right;
    test(root, expected);
    test2(root, expected);

    Node root2 = new Node(1, 0);
    test(root2, root2);
    test2(root2, root2);

    Node root3 = null;
    test(root3, null);
    test2(root3, null);

    Node root4 = new Node(1, 0);
    root4.right = new Node(2, 1);
    root4.right.right = new Node(3, 2);
    root4.right.right.left = new Node(4, 3);
    test(root4, root4.right.right.left);
    test2(root4, root4.right.right.left);
  }
}

class Node {
  int val;
  Node left;
  Node right;
  int depth;
  
  Node(int v, int d) {
    this.val = v;
    this.depth = d;
  }
}
