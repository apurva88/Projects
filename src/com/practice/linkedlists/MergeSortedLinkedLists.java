package com.practice.linkedlists;

public class MergeSortedLinkedLists {

	private Node root;

	public MergeSortedLinkedLists(int value) {
		this.root = new Node(value);
	}

	public static void main(String[] args) {
		MergeSortedLinkedLists list1 = new MergeSortedLinkedLists(2);
		list1.root.next = new Node(7);
		list1.root.next.next = new Node(10);
		list1.root.next.next.next = new Node(23);

		MergeSortedLinkedLists list2 = new MergeSortedLinkedLists(3);
		list2.root.next = new Node(8);
		list1.root.next.next = new Node(15);
		list1.root.next.next.next = new Node(25);

		Node result = mergeNonRecursive(list1.root, list2.root);

		while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}

	}

	public static Node mergeNonRecursive(Node list1, Node list2) {
		if (list1 == null)
			return null;

		if (list2 == null)
			return null;

		Node fakeHead = new Node(-1);
		Node result = fakeHead;

		while (list1 != null && list2 != null) {
			if (list1.value <= list2.value) {
				result.next = list1;
				list1 = list1.next;

			} else {
				result.next = list2;
				list2 = list2.next;
			}
			result = result.next;
		}

		if (list1 != null) {
			result.next = list1;
		} else if (list2 != null) {
			result.next = list2;
		}

		return fakeHead.next;

	}

	public static Node mergeInConstantSpace(Node list1, Node list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.value <= list2.value) {
			list1.next = mergeInConstantSpace(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeInConstantSpace(list2.next, list1);
			return list2;
		}

	}
}
