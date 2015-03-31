package com.practice.array;

import java.util.HashMap;
import java.util.Map;

public class FindPairsforSum {
	/**
	 * Complexity:O(n) Space:O(n) maintain a hashmap which holds sum-A[i] , A[i]
	 * if A[i] is a diff value for some element, it will be present as a key in
	 * the hashmap if it is present then print that key,value pair
	 * 
	 * otherwise add the diff and A[i] to the hashmap
	 */
	public static void main(String args[]) {

		int A[] = { 3, 9, -3, 5, 1, 2, 4 };
		int sum = 6;

		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {

			if (sumMap.containsKey(A[i])) {
				System.out.println("Pair is " + A[i] + " and "
						+ sumMap.get(A[i]));
			} else {
				sumMap.put(sum - A[i], A[i]);
			}
		}
	}

}
