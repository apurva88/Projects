package com.practice.google;

public class NumOfPerfectSquares {

	public static void main(String[] args) {

		int result = findPerfectSquare(12);
		System.out.println(result);

	}

	public static int findPerfectSquare(int num) {
		int[] table = new int[num + 1];

		table[0] = 0;
		table[1] = 1;

		for (int i = 2; i <= num; i++) {

			double sqrt = Math.sqrt(i);
			double floor = Math.floor(sqrt);
			if (floor == sqrt) {
				table[i] = 1;
			} else {
				int value = i - (int) (floor * floor);
				table[i] = 1 + table[value];
			}
		}

		return table[num - 1];
	}
}
