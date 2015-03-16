package com.practice.google;

public class OutputABPattern {

	public static void main(String args[]) {

		String result = getValue(15);
		System.out.println(result);
	}

	public static String getValue(int num) {
		if (num == 0)
			return "";

		StringBuffer sb = new StringBuffer();
		while (num > 0) {
			if ((num & 1) == 1) {
				sb.append("A");
			} else {
				sb.append('B');
				// skip the next number
				num = num - 1;
			}
			num = num >> 1;
		}
		return sb.reverse().toString();
	}
}
