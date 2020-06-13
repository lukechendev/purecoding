/*
Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

public class Solution {
  
  public void flatten(TreeNode root) {
  }

  public static void test(TreeNode input, TreeNode expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    s.flatten(input);
    // System.out.println(System.nanoTime() - ts);
    if ((input == expected && input == null) || input.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + input);
    }
  }

  public static void main(String[] args) {
    TreeNode input = new TreeNode(1);
    test(null, null);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}
}
