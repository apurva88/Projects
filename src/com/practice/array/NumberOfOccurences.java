package com.practice.array;

public class NumberOfOccurences {

	public static void main(String[] args) {
		int input[] = { 2, 2, 2, 4, 5, 6, 6, 6, 8, 9, 10, 10 };

		int result = findOccurences(input, 12, 0, input.length - 1);
		System.out.println(result);
	}

	public static int findOccurences(int input[], int number, int start, int end) {

		// find the first occurence of the number
		int firstOccurence = firstOccurence(input, start, end, number);
		if (firstOccurence == -1)
			return 0;

		int lastOccurence = lastOccurence(input, start, end, number);

		return lastOccurence - firstOccurence + 1;
	}

	public static int firstOccurence(int a[], int start, int end, int key) {
		if (start <= end) {
			int mid = (start + end) / 2;

			// check if mid is the firstOccurence
			if ((mid == start || a[mid - 1] < a[mid]) && a[mid] == key) {
				return mid;
			}
			// check if mid is greater than key
			if (a[mid] < key) {
				// search in the right half
				return firstOccurence(a, mid + 1, end, key);

			} else {
				return firstOccurence(a, start, mid - 1, key);
			}
		}
		return -1;
	}

	public static int lastOccurence(int a[], int start, int end, int key) {
		if (start <= end) {
			int mid = (start + end) / 2;

			// check if mid is the last occurence
			if ((mid == end || a[mid + 1] > a[mid]) && a[mid] == key) {
				return mid;
			}
			// check if mid is greater than key
			if (a[mid] > key) {
				// search in the left half
				return lastOccurence(a, start, mid - 1, key);
			} else {
				return lastOccurence(a, mid + 1, end, key);
			}
		}
		return -1;
	}
}
