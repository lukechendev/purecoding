// https://leetcode.com/problems/binary-tree-paths/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        dfsTreePaths(paths, path, root);
        return paths;
    }

    private void dfsTreePaths(List<String> paths, List<TreeNode> path, TreeNode root) {
        if (root.left == null && root.right == null) {
            paths.add(getPathStr(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left);
            dfsTreePaths(paths, path, root.left);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right);
            dfsTreePaths(paths, path, root.right);
            path.remove(path.size() - 1);
        }
    }

    private String getPathStr(List<TreeNode> path) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : path) {
            sb.append(node.val).append("->");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
