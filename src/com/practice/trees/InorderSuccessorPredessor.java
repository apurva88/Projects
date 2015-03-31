package com.practice.trees;

public class InorderSuccessorPredessor {
	private Node root;
	private static Node suc = null;
	private static Node pred = null;

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

	public InorderSuccessorPredessor(int value) {
		root = new Node(value);

	}

	public static void printTree(Node root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.value);
		printTree(root.right);
	}

	public static void findValues(Node root, int key) {
		if (root == null) {
			return;
		}

		if (root.value == key) {
			// inorder pred is rightmost in left subtree
			Node current = root.left;
			while (current != null && current.right != null) {
				current = current.right;
			}
			pred = current;

			current = root.right;
			while (current != null && current.left != null) {
				current = current.left;
			}
			suc = current;
			return;
		}
		if (root.value > key) {
			suc = root;
			findValues(root.left, key);
		}
		if (root.value < key) {

			pred = root;
			findValues(root.right, key);
		}

	}

	public static void main(String args[]) {

		InorderSuccessorPredessor tree = new InorderSuccessorPredessor(50);
		tree.root.left = tree.new Node(30);
		tree.root.right = tree.new Node(70);
		tree.root.left.left = tree.new Node(20);
		tree.root.left.right = tree.new Node(40);
		tree.root.right.left = tree.new Node(60);
		tree.root.right.right = tree.new Node(80);
		findValues(tree.root, 65);
		System.out.println(suc.value);
		System.out.println(pred.value);
	}
}
