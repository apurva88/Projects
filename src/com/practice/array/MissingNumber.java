package com.practice.array;

public class MissingNumber {

	public static void main(String[] args) {
		int input[] = { 0, 2, 3, 4, 5, 6 };

		int result = findMissing(input, 0, input.length - 1);
		System.out.println(result);
	}

	public static int findMissing(int[] input, int start, int end) {
		if (start < end) {
			// find middle
			int mid = (start + end) / 2;

			// get difference of index elements on either side of mid
			int rightDiff = end - mid;
			int leftDiff = mid - start;

			if (rightDiff == 1 && input[end] - input[mid] > 1) {
				return input[mid] + 1;
			}

			if (leftDiff == 1 && input[mid] - input[start] > 1) {
				return input[mid] - 1;
			}

			if (rightDiff != input[end] - input[mid]) {
				return findMissing(input, mid, end);
			} else if (leftDiff != input[mid] - input[start]) {
				return findMissing(input, start, mid);
			}

		}
		return -1;
	}
}
