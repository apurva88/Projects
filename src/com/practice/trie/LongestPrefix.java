package com.practice.trie;

public class LongestPrefix {

	private static TrieNode root;
	private static int nodeCount;

	public LongestPrefix() {
		root = new TrieNode();
		nodeCount = 0;
	}

	public void insert(String value) {
		TrieNode current = root;
		int level = 0;
		nodeCount++;
		for (level = 0; level < value.length(); level++) {
			// get index location
			int index = value.charAt(level) - (int) 'a';
			if (current.getChildren()[index] != null) {
				current = current.getChildren()[index];
			} else {
				TrieNode newNode = new TrieNode();
				current.getChildren()[index] = newNode;
				current = current.getChildren()[index];

			}
		}
		current.setValue(nodeCount);
	}

	public static String longestPrefix(String input) {
		StringBuffer result = new StringBuffer();
		int level = 0;
		TrieNode current = root;
		for (level = 0; level < input.length(); level++) {
			int index = input.charAt(level) - (int) 'a';
			if (current.getChildren()[index] != null) {
				current = current.getChildren()[index];
				result.append(input.charAt(level));
			} else {
				break;
			}
		}
		if (current.getValue() != 0) {
			return result.toString();
		} else
			return null;
	}

	public static void main(String args[]) {
		LongestPrefix trie = new LongestPrefix();

		trie.insert("cat");
		trie.insert("cater");
		trie.insert("caterer");

		String result = longestPrefix("catering");
		System.out.println(result);
	}

}
