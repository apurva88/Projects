package com.practice.trees;

public class GreaterSumTree {

	private Node root;

	private static int sum = 0;

	private class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;

		}
	}

	public GreaterSumTree(int value) {
		root = new Node(value);

	}

	public static void transform(Node root) {
		if (root == null) {
			return;
		}

		transform(root.right);
		sum = sum + root.value;

		root.value = sum - root.value;
		transform(root.left);

		return;

	}

	public static void printTree(Node root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.value);
		printTree(root.right);
	}

	public static void main(String[] args) {

		GreaterSumTree tree = new GreaterSumTree(11);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(29);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.right = tree.new Node(7);
		tree.root.right.left = tree.new Node(15);
		tree.root.right.right = tree.new Node(40);
		tree.root.right.right.left = tree.new Node(35);
		transform(tree.root);
		printTree(tree.root);
	}

}
