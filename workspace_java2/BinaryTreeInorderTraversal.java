/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> path = new ArrayList<>();
        inorderTraversal(root, path);
        return path;
    }

    private void inorderTraversal(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, path);
        path.add(root.val);
        inorderTraversal(root.right, path);
    }
}
