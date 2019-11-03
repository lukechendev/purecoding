/*
Binary Tree Maximum Path Sum
Solution
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/

public class Solution {

    int max_sum = Integer.MIN_VALUE;
    
    public int maxPathSumSample(TreeNode root) {
        maxPathSumHelper(root);
        return max_sum;
    }
    
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_gain = Math.max(maxPathSumHelper(root.left), 0); // max with 0 is the key here. it means to block any lose.
            int right_gain = Math.max(maxPathSumHelper(root.right), 0);
            int sum = left_gain + right_gain + root.val;
            max_sum = Math.max(max_sum, sum);
            return root.val + Math.max(left_gain, right_gain);
        }
    }


// ****************************************************************
  
  // Res, store the current max path sum inside this sub-tree
  // Return the max path sum from current node to any of child node
  int traverse(TreeNode node, Res res) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      res.max = Math.max(node.val, res.max);
      return node.val;
    }

    int lv = traverse(node.left, res);
    int rv = traverse(node.right, res);

    if (node.left != null && node.right != null) {
      res.max = Math.max(lv + node.val, res.max);
      res.max = Math.max(rv + node.val, res.max);
      res.max = Math.max(lv + rv + node.val, res.max);
      res.max = Math.max(node.val, res.max);

      int t = Math.max(lv + node.val, rv + node.val);
      return Math.max(t, node.val);
    }

    if (node.left != null) {
      res.max = Math.max(lv + node.val, res.max);
      res.max = Math.max(node.val, res.max);

      return Math.max(lv + node.val, node.val);
    } else {
      res.max = Math.max(rv + node.val, res.max);
      res.max = Math.max(node.val, res.max);

      return Math.max(rv + node.val, node.val);
    }
  }

  public int maxPathSum(TreeNode root) {
    Res res = new Res();
    res.max = Integer.MIN_VALUE;

    traverse(root, res);

    return res.max;
  }

  public static void test(TreeNode input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.maxPathSumSample(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    TreeNode input1 = new TreeNode(1);
    input1.left = new TreeNode(2);
    input1.right = new TreeNode(3);
    test(input1, 6);

    TreeNode input2 = new TreeNode(-10);
    input2.left = new TreeNode(9);
    input2.right = new TreeNode(20);
    input2.right.left = new TreeNode(15);
    input2.right.right = new TreeNode(7);
    test(input2, 42);

    TreeNode input3 = new TreeNode(0);
    test(input3, 0);

    TreeNode input4 = new TreeNode(3);
    test(input4, 3);

    TreeNode input5 = new TreeNode(1);
    input5.left = new TreeNode(2);
    test(input5, 3);

    TreeNode input6 = new TreeNode(1);
    input6.left = new TreeNode(2);
    input6.left.left = new TreeNode(3);
    test(input6, 6);

    TreeNode input7 = new TreeNode(1);
    input7.left = new TreeNode(-2);
    input7.right = new TreeNode(3);
    test(input7, 4);

    TreeNode input8 = new TreeNode(-1);
    input8.left = new TreeNode(2);
    input8.left.left = new TreeNode(3);
    input8.left.left.left = new TreeNode(-4);
    test(input8, 5);

    TreeNode input9 = new TreeNode(-2);
    input9.left = new TreeNode(1);
    input9.left.left = new TreeNode(2);
    input9.left.left.right = new TreeNode(3);
    input9.left.left.right.right = new TreeNode(-4);
    test(input9, 6);

    input9 = new TreeNode(100);
    input9.left = new TreeNode(-21);
    input9.left.left = new TreeNode(2);
    input9.left.left.right = new TreeNode(3);
    input9.left.left.right.right = new TreeNode(-4);
    test(input9, 100);

    input9 = new TreeNode(100);
    input9.left = new TreeNode(-21);
    input9.left.left = new TreeNode(2);
    input9.left.left.right = new TreeNode(3);
    input9.left.left.right.right = new TreeNode(-4);
    input9.right = new TreeNode(-1);
    input9.right.right = new TreeNode(100);
    test(input9, 199);

    input9 = new TreeNode(-1);
    input9.left = new TreeNode(21);
    input9.left.left = new TreeNode(-2);
    input9.left.left.right = new TreeNode(-3);
    input9.left.left.right.right = new TreeNode(-4);
    input9.right = new TreeNode(2);
    input9.right.right = new TreeNode(-100);
    test(input9, 22);
  }
}

class Res {
  int max;
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
  }
}
