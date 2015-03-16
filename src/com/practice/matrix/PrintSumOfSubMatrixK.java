package com.practice.matrix;

//TODO
public class PrintSumOfSubMatrixK {

	public static void main(String[] args) {
		int M[][] = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 },
				{ 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 }, };
		int k = 3;
		int S[][] = new int[M.length][M.length];
		int n = M.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (((i + 1) * (j + 1)) % k == 0) {

				} else {

				}
			}
		}

	}
}
