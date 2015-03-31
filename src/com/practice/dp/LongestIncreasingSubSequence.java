package com.practice.dp;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(longestSequence(input));
	}

	public static int longestSequence(int[] input) {
		int result = -1;
		int length[] = new int[input.length];

		for (int i = 0; i < length.length; i++) {
			length[i] = 1;
		}

		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && length[i] < 1 + length[j]) {
					length[i] = 1 + length[j];
				}
			}
		}

		result = length[0];
		for (int j = 1; j < length.length; j++) {
			if (length[j] > result) {
				result = length[j];
			}
		}
		return result;
	}
}
