package com.bridgelabz.algorithmprogram;

import java.util.Arrays;

public class AnagramDetector {

	public static boolean areAnagrams(String str1, String str2) {
		// Convert the strings to char arrays
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		// Sort the char arrays
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		// Convert the sorted char arrays back to strings
		String sortedStr1 = new String(charArray1);
		String sortedStr2 = new String(charArray2);

		// Check if the sorted strings are equal
		return sortedStr1.equals(sortedStr2);
	}

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "dcba";

		if (areAnagrams(str1, str2)) {
			System.out.println("The two strings are anagrams.");
		} else {
			System.out.println("The two strings are not anagrams.");
		}
	}
}
