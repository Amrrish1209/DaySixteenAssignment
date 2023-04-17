package com.bridgelabz.algorithmprogram;

import java.util.*;

public class PrimeAnagramPalindrome {
	public static void main(String[] args) {
		int range = 1000;
		ArrayList<Integer> primeAnagramPalindrome = new ArrayList<>();

		for (int i = 2; i < range; i++) {
			if (isPrime(i) && isAnagram(i) && isPalindrome(i)) {
				primeAnagramPalindrome.add(i);
			}
		}

		System.out.println("Prime numbers that are anagram and palindrome within the range 0 - " + range + ":");
		System.out.println(primeAnagramPalindrome);
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram(int num) {
		String numStr = Integer.toString(num);
		char[] numArr = numStr.toCharArray();
		Arrays.sort(numArr);
		String sortedNum = new String(numArr);
		for (int i = 2; i < num; i++) {
			String iStr = Integer.toString(i);
			char[] iArr = iStr.toCharArray();
			Arrays.sort(iArr);
			String sortedI = new String(iArr);
			if (iStr.equals(numStr)) {
				continue;
			}
			if (sortedNum.equals(sortedI)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isPalindrome(int num) {
		String numStr = Integer.toString(num);
		for (int i = 0; i < numStr.length() / 2; i++) {
			if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
