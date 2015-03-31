package com.practice.string;

public class RunLengthEncoding {

	public static void main(String[] args) {

		String result = calculateRunLength("aabbccdd");
		System.out.println(result);
	}

	public static String calculateRunLength(String input) {
		if (input == null || input.isEmpty())
			return input;

		StringBuffer result = new StringBuffer();
		result.append(input.charAt(0));
		int count = 1;

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == input.charAt(i)) {
				count++;
			} else {
				result.append(count);
				result.append(input.charAt(i));
				count = 1;
			}
		}
		result.append(count);
		return result.toString();
	}
}
