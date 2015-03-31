package com.practice.string;

public class PrintStringRecursive {

	public static void main(String args[]) {
		for (int i = 0; i < 3; i++) {
			printString("abc", i, 2);
		}
	}

	public static void printString(String input, int start, int end) {

		if (start <= end) {
			printString(input, start, end - 1);
			System.out.println(input.substring(start, end + 1));
		}
	}
}
