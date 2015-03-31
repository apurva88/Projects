package com.practice.trie;

public class TrieNode {

	private final static int ALPHABET_SIZE = 26;
	private int value;
	private TrieNode children[];

	public TrieNode() {
		this.children = new TrieNode[ALPHABET_SIZE];
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

}
