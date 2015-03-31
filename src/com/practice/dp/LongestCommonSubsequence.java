package com.practice.dp;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String a = "ABCDGH";
		String b = "AEDFHR";

		System.out.println(findCommonLength(a, b));
	}

	public static int findCommonLength(String a, String b) {

		int C[][] = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {

				if (i == 0 || j == 0) {
					C[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					C[i][j] = 1 + C[i - 1][j - 1];
				} else {
					C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
				}
			}
		}

		return C[a.length()][b.length()];
	}
}
