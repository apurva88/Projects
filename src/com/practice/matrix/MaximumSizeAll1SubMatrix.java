package com.practice.matrix;

public class MaximumSizeAll1SubMatrix {

	public static void main(String[] args) {

		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		System.out.println("INPUT");

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("OUTPUT");
		printSubMatrixWithMaximumSize(M);
	}

	/**
	 * Complexity O(m*n)
	 * 
	 * @param M
	 */
	public static void printSubMatrixWithMaximumSize(int[][] M) {
		// initialize auxiliary matrix
		// S[i][j] will hold the size of the sub-matrix with all 1s, including
		// M[i][j], where M[i][j] is the last elemenet int he sub-matrix
		if (M.length == 0)
			return;

		int[][] S = new int[M.length][M[0].length];

		int m = M.length;
		int n = M[0].length;
		int i = 0, j = 0;
		// first row and column will be same as M
		for (i = 0; i < m; i++) {
			S[i][0] = M[i][0];

		}

		for (j = 0; j < n; j++) {
			S[0][j] = M[0][j];
		}

		/*
		 * for each element i,j. find the sub-matrix size for i-1,j-1 i,j-1 and
		 * i-1,j Take the minimum value of it and add one. this will be S[i][j]
		 * We take minimum because each of the values should be at the same
		 * number atleast.
		 */
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {

				if (M[i][j] == 1) {

					S[i][j] = Math.min(S[i - 1][j],
							Math.min(S[i - 1][j - 1], S[i][j - 1])) + 1;

				} else {
					S[i][j] = 0;
				}
			}
		}

		// Find maximum entry in S
		int max = S[0][0], maxI = 0, maxJ = 0;
		for (i = 1; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (S[i][j] > max) {
					max = S[i][j];
					maxI = i;
					maxJ = j;
				}

			}
		}

		int startI = maxI - max + 1;
		int startJ = maxJ - max + 1;
		for (i = startI; i <= maxI; i++) {
			for (j = startJ; j <= maxJ; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
