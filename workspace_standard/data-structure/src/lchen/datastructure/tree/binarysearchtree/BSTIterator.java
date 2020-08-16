package lchen.datastructure.tree.binarysearchtree;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		gotoMostLeft(root);
	}

	private void gotoMostLeft(TreeNode node) {
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode next() {
		TreeNode next = stack.pop();

		if (next.right != null) {
			gotoMostLeft(next.right);
		}

		return next;
	}
}

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode(int val) {
		this.val = val;
	}
}