package com.practice.linkedlists;

public class Node {
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int value;
	public Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}