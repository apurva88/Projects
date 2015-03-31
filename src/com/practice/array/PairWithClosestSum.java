package com.practice.array;

public class PairWithClosestSum {
	private static int INF = 1000;

	public static void main(String[] args) {
		int input[] = { 1, 3, 4, 15, 32, 45 };
		int sum = 8;

		findPair(input, sum);
	}

	public static void findPair(int[] input, int sum) {
		int i = 0;
		int j = input.length - 1;

		int minDiff = INF, minI = -1, minJ = -1;
		// get difference of elements at i and j position
		while (i < j) {
			if (Math.abs((input[j] + input[i]) - sum) == 0) {
				System.out.println("Pair with sum closest to target is :"
						+ input[i] + " and " + input[j]);
				return;
			}
			if (Math.abs((input[j] + input[i]) - sum) < minDiff) {
				minDiff = Math.abs((input[j] - input[i]) - sum);
				minI = i;
				minJ = j;
			}
			if (input[j] + input[i] < sum) {
				// move i forward to get greater sum values
				i++;
			} else if (input[j] + input[i] > sum) {
				// move j backwards to get lower sum values
				j--;
			}

		}
		System.out.println("Pair with sum closest to target is :" + input[minI]
				+ " and " + input[minJ]);
	}

}
