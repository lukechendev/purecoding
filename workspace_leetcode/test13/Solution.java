/*
Validate Binary Search Tree
Solution
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/
public class Solution {

  class Ret {
    int max;
    int min;
    boolean valid;
  }

  // Returns the max from the sub-tree
  private Ret inorder(TreeNode root) {
    Ret ret = new Ret();

    int cur = root.val;
    if (root.left != null) {
      Ret lv = inorder(root.left);
      if (!lv.valid) {
	ret.valid = false;
	return ret;
      }

      if (lv.max >= cur) {
	ret.valid = false;
	return ret;
      }
      ret.min = lv.min;
    } else {
      ret.min = cur;
    }

    if (root.right != null) {
      Ret lr = inorder(root.right);
      if (!lr.valid) {
        ret.valid = false;
        return ret;
      }

      if (cur >= lr.min) {
	ret.valid = false;
	return ret;
      }
      ret.max = lr.max;
    } else {
      ret.max = cur;
    }

    ret.valid = true;

    return ret;
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    Ret ret = inorder(root);
    return ret.valid;
  }

  public static void test(TreeNode input, boolean expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    boolean ret = s.isValidBST(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    TreeNode input = new TreeNode(2);
    input.left = new TreeNode(1);
    input.right = new TreeNode(3);
    test(input, true);

    input = new TreeNode(5);
    input.left = new TreeNode(1);
    input.right = new TreeNode(4);
    input.right.left = new TreeNode(3);
    input.right.right = new TreeNode(6);
    test(input, false);

    input = null; // "[]"
    test(input, true);

    input = new TreeNode(1);
    input.left = new TreeNode(1);
    test(input, false);

    input = new TreeNode(6);
    input.left = new TreeNode(-51);
    input.right = new TreeNode(87);
    input.right.right = new TreeNode(-46);
    test(input, false);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;};
}
