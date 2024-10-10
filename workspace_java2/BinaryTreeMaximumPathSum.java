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
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        return getMaxPathSum(root).maxPathSum;
    }

    private Ret getMaxPathSum(TreeNode root) {
        Ret ret = new Ret();
        if (root == null) {
            return ret;
        }

        Ret lret = getMaxPathSum(root.left);
        Ret rret = getMaxPathSum(root.right);

        ret.maxPathSumToRoot = Math.max(0, Math.max(lret.maxPathSumToRoot, rret.maxPathSumToRoot)) + root.val;
        ret.maxPathSum = Math.max(lret.maxPathSum, rret.maxPathSum);
        ret.maxPathSum = Math.max(ret.maxPathSum, Math.max(0, lret.maxPathSumToRoot) + Math.max(0, rret.maxPathSumToRoot) + root.val);

        return ret;
    }

    class Ret {
        int maxPathSum = Integer.MIN_VALUE;
        int maxPathSumToRoot = 0;
    }

}
