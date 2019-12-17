/*
  Tree travesal
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class Node {
  int val;
  Node left;
  Node right;

  public Node(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}

public class Solution {

  private void printQueue(Queue<Node> q) {
    System.out.println();

    Iterator<Node> i = q.iterator();
    while (i.hasNext()) {
      System.out.print(i.next().val + " ");
    }
    System.out.println();
  }
  
  public String BFS(Node root) {
    StringBuffer buff = new StringBuffer();

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      if (cur != null) {
        buff.append(cur.val + " ");

        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
    }

    return buff.toString().trim();
  }

  private void doInorder(StringBuffer buff, Node node) {
    if (node != null) {
      doInorder(buff, node.left);
      buff.append(node.val + " ");
      doInorder(buff, node.right);
    }
  }

  private void doPreorder(StringBuffer buff, Node node) {
    if (node != null) {
      buff.append(node.val + " ");
      doPreorder(buff, node.left);
      doPreorder(buff, node.right);
    }
  }

  private void doPostorder(StringBuffer buff, Node node) {
    if (node != null) {
      doPostorder(buff, node.left);
      doPostorder(buff, node.right);
      buff.append(node.val + " ");
    }
  }

  public String inorder(Node root) {
    StringBuffer buff = new StringBuffer();

    doInorder(buff, root);

    return buff.toString().trim();
  }

  public String preorder(Node root) {
    StringBuffer buff = new StringBuffer();

    doPreorder(buff, root);

    return buff.toString().trim();
  }

  public String postorder(Node root) {
    StringBuffer buff = new StringBuffer();

    doPostorder(buff, root);

    return buff.toString().trim();
  }

  public static void testBFS(Node tree, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.BFS(tree);
    // System.out.println(System.nanoTime() - ts);
    if (expected.equals(ret)) {
      System.out.println("Passed");
    } else {
      System.out.println("Expected: " + expected + "\nFailed: " + ret);
    }
  }

  public static void testInorder(Node tree, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.inorder(tree);
    // System.out.println(System.nanoTime() - ts);

    System.out.println();
    if (expected.equals(ret)) {
      System.out.println("Passed");
    } else {
      System.out.println("Expected: " + expected + "\nFailed: " + ret);
    }
  }

  public static void testPreorder(Node tree, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.preorder(tree);
    // System.out.println(System.nanoTime() - ts);

    System.out.println();
    if (expected.equals(ret)) {
      System.out.println("Passed");
    } else {
      System.out.println("Expected: " + expected + "\nFailed: " + ret);
    }
  }

  public static void testPostorder(Node tree, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.postorder(tree);
    // System.out.println(System.nanoTime() - ts);

    System.out.println();
    if (expected.equals(ret)) {
      System.out.println("Passed");
    } else {
      System.out.println("Expected: " + expected + "\nFailed: " + ret);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1); 
    root.left = new Node(2); 
    root.right = new Node(3); 
    root.right.right = new Node(6); 
    root.right.right.left = new Node(7); 
    root.right.right.right = new Node(8); 
    root.left.left = new Node(4); 
    root.left.right = new Node(5); 

    String expected = "1 2 3 4 5 6 7 8";
    testBFS(root, expected);

    expected = "4 2 5 1 3 7 6 8";
    testInorder(root, expected);

    expected = "1 2 4 5 3 6 7 8";
    testPreorder(root, expected);

    expected = "4 5 2 7 8 6 3 1";
    testPostorder(root, expected);
  }
}
